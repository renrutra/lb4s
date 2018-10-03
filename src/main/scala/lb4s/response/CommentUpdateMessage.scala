package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param type the type of message
  * @param code the error message code
  * @param title the error message text in human-readable form
  */
case class CommentUpdateMessage(`type`: String, code: Option[String], title: Option[String])

object CommentUpdateMessage {
  implicit val format: Format[CommentUpdateMessage] = Json.format[CommentUpdateMessage]
}
