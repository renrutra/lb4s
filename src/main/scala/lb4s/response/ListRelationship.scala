package lb4s.response

import lb4s.primitive.{CommentThreadState, SubscriptionState}
import play.api.libs.json.{Format, Json}

/**
  * @param liked true if the member likes the list
  * @param subscribed true if the member is subscribed to comment notifications for the list
  * @param subscriptionState the member's subscription state for comment notifications
  * @param commentThreadState the authenticated member's state with respect to adding comments for this list
  */
case class ListRelationship(
  liked: Boolean,
  subscribed: Boolean,
  subscriptionState: SubscriptionState.Value,
  commentThreadState: CommentThreadState.Value
)

object ListRelationship {
  implicit val format: Format[ListRelationship] = Json.format[ListRelationship]
}
