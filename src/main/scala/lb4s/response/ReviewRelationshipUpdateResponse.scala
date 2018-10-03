package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class ReviewRelationshipUpdateResponse(data: ReviewRelationship, messages: List[ReviewRelationshipUpdateMessage])

object ReviewRelationshipUpdateResponse {
  implicit val format: Format[ReviewRelationshipUpdateResponse] = Json.format[ReviewRelationshipUpdateResponse]
}
