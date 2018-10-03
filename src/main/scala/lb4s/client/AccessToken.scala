package lb4s.client

import play.api.libs.json.{Format, JsPath}

import scala.concurrent.duration.Duration

case class AccessToken(accessToken: String, tokenType: String, expiresIn: Duration, refreshToken: String)

object AccessToken {
  import play.api.libs.functional.syntax._
  import scala.concurrent.duration._

  implicit val format: Format[AccessToken] = (
    (JsPath \ "access_token").format[String] and
    (JsPath \ "token_type").format[String] and
    (JsPath \ "expires_in").format[Int].inmap[Duration](_.seconds, _.toSeconds.toInt) and
    (JsPath \ "refresh_token").format[String]
  )(AccessToken.apply, unlift(AccessToken.unapply))
}
