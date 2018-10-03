package lb4s.response

import lb4s.primitive.Time
import play.api.libs.json.{Format, Json}

/**
  * @param lbml the review text in LBML
  * @param containsSpoilers true if the member has indicated that the review field contains plot spoilers for the film
  * @param canShareOn the third-party services to which this review can be shared
  * @param sharedOn the third-party services to which this review has been shared
  * @param whenReviewed the time when this log entry's review was first published
  * @param text the review text formatted as HTML
  */
case class Review(
  lbml: Option[String],
  containsSpoilers: Boolean,
  canShareOn: Option[List[String]],
  sharedOn: Option[List[String]],
  whenReviewed: Time,
  text: Option[String]
)

object Review {
  implicit val format: Format[Review] = Json.format[Review]
}
