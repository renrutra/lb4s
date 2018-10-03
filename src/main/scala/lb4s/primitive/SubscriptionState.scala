package lb4s.primitive

import play.api.libs.json.Format

object SubscriptionState extends Enumeration {
  import play.api.libs.functional.syntax._

  val Subscribed, NotSubscribed, Unsubscribed = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
