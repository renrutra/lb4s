package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param liked true if the member likes the list, or false to unlike the list
  * @param subscribed true to subscribe the member to comment notifications for the list, or false to unsubscribe them
  */
case class ListRelationshipUpdateRequest(liked: Option[Boolean] = None, subscribed: Option[Boolean] = None)

object ListRelationshipUpdateRequest {
  implicit val format: Format[ListRelationshipUpdateRequest] = Json.format[ListRelationshipUpdateRequest]
}
