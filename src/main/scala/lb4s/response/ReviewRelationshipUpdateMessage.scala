package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param type the type of message
  * @param code the error message code
  * @param title the error message text in human-readable form
  */
case class ReviewRelationshipUpdateMessage(`type`: String, code: Option[String], title: Option[String])

object ReviewRelationshipUpdateMessage {
  implicit val format: Format[ReviewRelationshipUpdateMessage] = Json.format[ReviewRelationshipUpdateMessage]
}
