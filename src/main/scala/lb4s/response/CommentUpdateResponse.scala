package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class CommentUpdateResponse(data: AbstractComment, messages: List[CommentUpdateMessage])

object CommentUpdateResponse {
  implicit val format: Format[CommentUpdateResponse] = Json.format[CommentUpdateResponse]
}
