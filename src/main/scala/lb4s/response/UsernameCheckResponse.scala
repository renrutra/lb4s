package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param result "Available" if the username is available to register, or an appropriate error value
  */
case class UsernameCheckResponse(result: String)

object UsernameCheckResponse {
  implicit val format: Format[UsernameCheckResponse] = Json.format[UsernameCheckResponse]
}
