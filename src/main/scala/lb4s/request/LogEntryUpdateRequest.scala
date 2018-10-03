package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param diaryDetails information about this log entry if adding to the member's diary
  * @param review information about the review
  * @param tags the tags for the log entry
  * @param rating a rating between 0.5 and 5.0, with increments of 0.5
  * @param like true if the member likes the film
  */
case class LogEntryUpdateRequest(
  diaryDetails: Option[LogEntryUpdateRequest],
  review: Option[LogEntryUpdateRequestReview],
  tags: Option[List[String]],
  rating: Option[Double],
  like: Option[Boolean]
)

object LogEntryUpdateRequest {
  implicit val format: Format[LogEntryUpdateRequest] = Json.format[LogEntryUpdateRequest]
}
