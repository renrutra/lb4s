package lb4s.request

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param filmId the film being logged
  * @param diaryDetails information about this log entry if adding to the member's diary
  * @param review information about the review if adding a review
  * @param tags the tags for the log entry
  * @param rating a rating between 0.5 and 5.0, with increments of 0.5
  * @param like true if the member likes the film
  */
case class LogEntryCreationRequest(
  filmId: LBID,
  diaryDetails: Option[LogEntryCreationRequestDiaryDetails] = None,
  review: Option[LogEntryCreationRequestReview] = None,
  tags: List[String] = Nil,
  rating: Option[Double] = None,
  like: Option[Boolean] = None
)

object LogEntryCreationRequest {
  implicit val format: Format[LogEntryCreationRequest] = Json.format[LogEntryCreationRequest]
}
