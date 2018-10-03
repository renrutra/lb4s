package lb4s.response

import lb4s.primitive.Time
import play.api.libs.json.{Format, JsObject, JsString, JsValue, Json, Reads, Writes}

sealed trait AbstractActivity {
  def `type`: String
  def member: MemberSummary
  def whenCreated: Time
}

case class DiaryEntryActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  diaryEntry: LogEntry
) extends AbstractActivity

case class FilmLikeActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  film: FilmSummary
) extends AbstractActivity

case class FilmRatingActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  film: FilmSummary,
  rating: Double
) extends AbstractActivity

case class FilmWatchActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  film: FilmSummary
) extends AbstractActivity

case class FollowActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  followed: MemberSummary
) extends AbstractActivity

case class InvitationAcceptedActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  invitor: MemberSummary
) extends AbstractActivity

case class ListActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  list: ListSummary,
  clonedFrom: Option[ListSummary]
) extends AbstractActivity

case class ListCommentActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  list: ListSummary,
  comment: ListComment
) extends AbstractActivity

case class ListLikeActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  list: ListSummary
) extends AbstractActivity

case class RegistrationActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time
) extends AbstractActivity

case class ReviewActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  review: LogEntry
) extends AbstractActivity

case class ReviewCommentActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  review: LogEntry,
  comment: ReviewComment
) extends AbstractActivity

case class ReviewLikeActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  review: LogEntry
) extends AbstractActivity

case class WatchlistActivity(
  `type`: String,
  member: MemberSummary,
  whenCreated: Time,
  film: FilmSummary
) extends AbstractActivity

object AbstractActivity {
  import play.api.libs.functional.syntax._

  private val diaryEntryFormat         = Json.format[DiaryEntryActivity]
  private val filmLikeFormat           = Json.format[FilmLikeActivity]
  private val filmRatingFormat         = Json.format[FilmRatingActivity]
  private val filmWatchFormat          = Json.format[FilmWatchActivity]
  private val followFormat             = Json.format[FollowActivity]
  private val invitationAcceptedFormat = Json.format[InvitationAcceptedActivity]
  private val listFormat               = Json.format[ListActivity]
  private val listCommentFormat        = Json.format[ListCommentActivity]
  private val listLikeFormat           = Json.format[ListLikeActivity]
  private val registrationFormat       = Json.format[RegistrationActivity]
  private val reviewFormat             = Json.format[ReviewActivity]
  private val reviewCommentFormat      = Json.format[ReviewCommentActivity]
  private val reviewLikeFormat         = Json.format[ReviewLikeActivity]
  private val watchlistFormat          = Json.format[WatchlistActivity]

  private val reads: Reads[AbstractActivity] = Reads.of[JsObject].flatMap[AbstractActivity](
    _.value("type").as[String] match {
      case "DiaryEntryActivity"         => diaryEntryFormat        .map(identity)
      case "FilmLikeActivity"           => filmLikeFormat          .map(identity)
      case "FilmRatingActivity"         => filmRatingFormat        .map(identity)
      case "FilmWatchActivity"          => filmWatchFormat         .map(identity)
      case "FollowActivity"             => followFormat            .map(identity)
      case "InvitationAcceptedActivity" => invitationAcceptedFormat.map(identity)
      case "ListActivity"               => listFormat              .map(identity)
      case "ListCommentActivity"        => listCommentFormat       .map(identity)
      case "ListLikeActivity"           => listLikeFormat          .map(identity)
      case "RegistrationActivity"       => registrationFormat      .map(identity)
      case "ReviewActivity"             => reviewFormat            .map(identity)
      case "ReviewCommentActivity"      => reviewCommentFormat     .map(identity)
      case "ReviewLikeActivity"         => reviewLikeFormat        .map(identity)
      case "WatchlistActivity"          => watchlistFormat         .map(identity)
    }
  )

  private val writes: Writes[AbstractActivity] = Writes.of[JsValue].contramap[AbstractActivity]({
    case a: DiaryEntryActivity         => Json.toJson(a)
    case a: FilmLikeActivity           => Json.toJson(a)
    case a: FilmRatingActivity         => Json.toJson(a)
    case a: FilmWatchActivity          => Json.toJson(a)
    case a: FollowActivity             => Json.toJson(a)
    case a: InvitationAcceptedActivity => Json.toJson(a)
    case a: ListActivity               => Json.toJson(a)
    case a: ListCommentActivity        => Json.toJson(a)
    case a: ListLikeActivity           => Json.toJson(a)
    case a: RegistrationActivity       => Json.toJson(a)
    case a: ReviewActivity             => Json.toJson(a)
    case a: ReviewCommentActivity      => Json.toJson(a)
    case a: ReviewLikeActivity         => Json.toJson(a)
    case a: WatchlistActivity          => Json.toJson(a)
  })

  implicit val format: Format[AbstractActivity] = Format(reads, writes)
}
