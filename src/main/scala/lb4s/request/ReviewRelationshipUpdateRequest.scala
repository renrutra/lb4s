package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param liked true if the member likes the review
  * @param subscribed true to subscribe the member to comment notifications for the review, or false to unsubscribe them
  */
case class ReviewRelationshipUpdateRequest(liked: Option[Boolean], subscribed: Option[Boolean])

object ReviewRelationshipUpdateRequest {
  implicit val format: Format[ReviewRelationshipUpdateRequest] = Json.format[ReviewRelationshipUpdateRequest]
}
