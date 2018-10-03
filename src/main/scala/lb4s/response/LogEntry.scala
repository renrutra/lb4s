package lb4s.response

import lb4s.primitive.{LBID, Time}
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the log entry
  * @param name a descriptive title for the log entry
  * @param owner the member who created the log entry
  * @param film the film being logged
  * @param diaryDetails details about the log entry
  * @param review review details for the log entry
  * @param tags2 the tags for the log entry
  * @param whenCreated the time when the log entry was created
  * @param whenUpdated the time when the log entry was last updated
  * @param rating the member's rating for the film
  * @param like true if the member likes the film
  * @param commentable true if the log entry can have comments
  * @param links a list of relevant URLs for this entity, on Letterboxd and external sites
  */
case class LogEntry(
  id: LBID,
  name: String,
  owner: MemberSummary,
  film: FilmSummary,
  diaryDetails: Option[DiaryDetails],
  review: Option[Review],
  tags2: List[Tag],
  whenCreated: Time,
  whenUpdated: Time,
  rating: Option[Double],
  like: Boolean,
  commentable: Boolean,
  links: List[Link]
)

object LogEntry {
  implicit val format: Format[LogEntry] = Json.format[LogEntry]
}
