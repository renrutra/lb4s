package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class MemberRelationshipUpdateResponse(data: MemberRelationship, messages: List[MemberRelationshipUpdateMessage])

object MemberRelationshipUpdateResponse {
  implicit val format: Format[MemberRelationshipUpdateResponse] = Json.format[MemberRelationshipUpdateResponse]
}
