package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param comment the message portion of the comment in LBML
  */
case class CommentUpdateRequest(comment: String)

object CommentUpdateRequest {
  implicit val format: Format[CommentUpdateRequest] = Json.format[CommentUpdateRequest]
}
