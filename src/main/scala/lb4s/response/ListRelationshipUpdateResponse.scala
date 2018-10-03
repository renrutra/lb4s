package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class ListRelationshipUpdateResponse(data: ListRelationship, messages: List[ListRelationshipUpdateMessage])

object ListRelationshipUpdateResponse {
  implicit val format: Format[ListRelationshipUpdateResponse] = Json.format[ListRelationshipUpdateResponse]
}
