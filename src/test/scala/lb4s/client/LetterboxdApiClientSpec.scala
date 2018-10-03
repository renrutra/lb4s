package lb4s.client

import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

import scala.io.Source

trait LetterboxdApiClientSpec extends WordSpec with Matchers {
  def unauthorizedClient: UnauthorizedLetterboxdClient = LetterboxdApiClientSpec.UNAUTHORIZED_CLIENT
  def authorizedClient: AuthorizedLetterboxdClient = LetterboxdApiClientSpec.AUTHORIZED_CLIENT
}

object LetterboxdApiClientSpec {
  private lazy val API_CREDENTIALS_FILENAME = "src/test/resources/api_credentials.json"
  private lazy val API_CREDENTIALS = Json.parse(Source.fromFile(API_CREDENTIALS_FILENAME).mkString).as[Map[String, String]]

  private lazy val USERNAME = API_CREDENTIALS("username")
  private lazy val PASSWORD = API_CREDENTIALS("password")

  private lazy val API_KEY = API_CREDENTIALS("api_key")
  private lazy val API_SECRET = API_CREDENTIALS("api_secret")

  private lazy val UNAUTHORIZED_CLIENT = new UnauthorizedLetterboxdClient(API_KEY, API_SECRET)
  private lazy val AUTHORIZED_CLIENT = UNAUTHORIZED_CLIENT.authorize(USERNAME, PASSWORD)
}
