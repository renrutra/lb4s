package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class FilmRelationshipUpdateResponse(data: FilmRelationship, messages: List[FilmRelationshipUpdateMessage])

object FilmRelationshipUpdateResponse {
  implicit val format: Format[FilmRelationshipUpdateResponse] = Json.format[FilmRelationshipUpdateResponse]
}
