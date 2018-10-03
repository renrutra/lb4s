package lb4s.response

import play.api.libs.json.{Format, Json}

case class ErrorResponse(error: Boolean, message: String)

object ErrorResponse {
  implicit val format: Format[ErrorResponse] =
    Format(Json.reads[ErrorResponse].filter(_.error), Json.writes[ErrorResponse])
}

