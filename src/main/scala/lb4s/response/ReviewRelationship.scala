package lb4s.response

import lb4s.primitive.{CommentThreadState, SubscriptionState}
import play.api.libs.json.{Format, Json}

/**
  * @param liked true if the member likes the review
  * @param subscribed true if the member is subscribed to comment notifications for the review
  * @param subscriptionState the member's subscription state for comment notifications
  * @param commentThreadState the authenticated member's state with respect to adding comments for this review
  */
case class ReviewRelationship(
  liked: Boolean,
  subscribed: Boolean,
  subscriptionState: SubscriptionState.Value,
  commentThreadState: CommentThreadState.Value
)

object ReviewRelationship {
  implicit val format: Format[ReviewRelationship] = Json.format[ReviewRelationship]
}
