package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param text the review text in LBML
  * @param containsSpoilers true if the member has indicated that the review field contains plot spoilers for the film
  * @param share the third-party services to which this review should be shared
  */
case class LogEntryCreationRequestReview(text: String, containsSpoilers: Boolean, share: List[String])

object LogEntryCreationRequestReview {
  implicit val format: Format[LogEntryCreationRequestReview] = Json.format[LogEntryCreationRequestReview]
}
