package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param comment the message portion of the comment in LBML
  */
case class CommentCreationRequest(comment: String)

object CommentCreationRequest {
  implicit val format: Format[CommentCreationRequest] = Json.format[CommentCreationRequest]
}
