package lb4s.client

import java.net.URLEncoder
import java.util.UUID
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.HmacAlgorithms
import org.apache.http.HttpHeaders
import play.api.libs.json.{JsArray, JsError, JsObject, JsString, JsSuccess, Json, Reads, Writes}

import scala.util.Try
import scalaj.http.{Http, HttpRequest, HttpResponse}

abstract class LetterboxdApiClient
  extends LetterboxdAuthClient
  with LetterboxdCommentClient
  with LetterboxdContributorClient
  with LetterboxdFilmClient
  with LetterboxdFilmCollectionClient
  with LetterboxdListClient
  with LetterboxdLogEntryClient
  with LetterboxdMeClient
  with LetterboxdMemberClient
  with LetterboxdNewsClient
  with LetterboxdSearchClient {
  import HttpHeaders._
  import LetterboxdApiClient._

  def apiKey: String
  def apiSecret: String
  def accessToken: Option[AccessToken]

  private def signUrl(method: String, url: String, body: String): String = {
    val saltedString = List(method, url, body).mkString("\u0000")
    val sha256Hmac = Mac.getInstance(HmacAlgorithms.HMAC_SHA_256.getName)
    sha256Hmac.init(new SecretKeySpec(apiSecret.getBytes, sha256Hmac.getAlgorithm))

    val signature = new String(Hex.encodeHex(sha256Hmac.doFinal(saltedString.getBytes)))
    f"$url&signature=$signature"
  }

  protected def buildRequest(method: String, path: String, body: String = "", params: List[(String, String)] = Nil): HttpRequest = {
    val fullParams = params ++ List(
      "apikey" -> apiKey,
      "nonce" -> getNonce.toString,
      "timestamp" -> (System.currentTimeMillis / 1000).toString
    )
    val queryString = fullParams.map({ case (key, value) => f"$key=${URLEncoder.encode(value, "UTF-8")}" }).mkString("&")
    val url = LETTERBOXD_API_URL + path + "?" + queryString
    val signedUrl = signUrl(method, url, body)

    val headers = List(ACCEPT -> "application/json") ++
      accessToken.map(token => AUTHORIZATION -> f"${token.tokenType} ${token.accessToken}")

    val request = Http(signedUrl)
      .headers(headers)
      .timeout(
        connTimeoutMs = CONNECTION_TIMEOUT.toMillis.toInt,
        readTimeoutMs = READ_TIMEOUT.toMillis.toInt
      )

    if (method == "GET") request else request.postData(body).method(method)
  }

  protected def parseResponse[T](response: HttpResponse[String])(implicit reads: Reads[T]): T =
    Json.fromJson[T](Json.parse(response.body)) match {
      case JsSuccess(value, _) => value
      case JsError(errors) =>
        errors.foreach({ case (jsPath, validationErrors) => System.err.println(f"$jsPath $validationErrors") })
        throw new RuntimeException("Invalid JSON response.")
    }

  protected def makeRequest(request: HttpRequest): HttpResponse[String] = {
    val response = request.asString

    if (response.isError) {
      System.err.println(f"Request failed: $request")

      Try(Json.parse(response.body)).toOption.flatMap(_.asOpt[ErrorResponse]) match {
        case Some(ErrorResponse(true, message)) =>
          throw new RuntimeException(message)
        case _ =>
          System.err.println(response)
          response.throwError
      }
    }

    response
  }

  private def makeJsonRequest[T](method: String, path: String, body: T)(implicit writes: Writes[T]): HttpResponse[String] = {
    val request = buildRequest(method, path, Json.toJson(body).toString)
      .header(CONTENT_TYPE, "application/json")

    makeRequest(request)
  }

  protected def getRequest[T, U](path: String, body: T)(implicit writes: Writes[T], reads: Reads[U]): U = {
    Json.toJson(body).as[JsObject]

    val params = Json.toJson(body).as[JsObject].fields.toList
      .flatMap({
        case (key, JsArray(array)) => array.map(key -> _)
        case (key, other) => List(key -> other)
      })
      .map({
        case (key, JsString(string)) => key -> string
        case (key, other) => key -> other.toString
      })

    getRequest[U](path, params)
  }

  protected def getRequest[T](path: String, params: List[(String, String)] = Nil)(implicit reads: Reads[T]): T =
    parseResponse[T](makeRequest(buildRequest("GET", path, params = params)))

  protected def patchRequest[T, U](path: String, body: T)(implicit writes: Writes[T], reads: Reads[U]): U =
    parseResponse[U](makeJsonRequest("PATCH", path, body))

  protected def postRequest[T](path: String, body: T)(implicit writes: Writes[T]): HttpResponse[String] =
    makeJsonRequest("POST", path, body)

  protected def postRequest[T, U](path: String, body: T)(implicit writes: Writes[T], reads: Reads[U]): U =
    parseResponse[U](postRequest[T](path, body))

  protected def putRequest[T, U](path: String, body: T)(implicit writes: Writes[T], reads: Reads[U]): U =
    parseResponse[U](makeJsonRequest("PUT", path, body))

  protected def deleteRequest(path: String): HttpResponse[String] =
    makeRequest(buildRequest("DELETE", path))
}

object LetterboxdApiClient {
  import scala.concurrent.duration._

  val LETTERBOXD_API_URL = "https://api.letterboxd.com/api/v0"
  private val CONNECTION_TIMEOUT = 5.seconds
  private val READ_TIMEOUT = 1.minute

  private val NONCES = Iterator.continually(UUID.randomUUID())
  private def getNonce = NONCES.synchronized(NONCES.next())

  private implicit val errorResponseReads: Reads[ErrorResponse] = Json.reads[ErrorResponse]

  private case class ErrorResponse(error: Boolean, message: String)
}
