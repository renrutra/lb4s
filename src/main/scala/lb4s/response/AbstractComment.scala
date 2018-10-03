package lb4s.response

import lb4s.primitive.{LBID, Time}
import play.api.libs.json.{Format, JsObject, JsString, JsValue, Json, Reads, Writes}

sealed trait AbstractComment {
  def id: LBID
  def member: MemberSummary
  def whenCreated: Time
  def whenUpdated: Time
  def commentLbml: Option[String]
  def removedByAdmin: Boolean
  def deleted: Boolean
  def blocked: Boolean
  def blockedByOwner: Boolean
  def editableWindowExpiresIn: Option[Int]
  def comment: Option[String]
}

case class ListComment(
  id: LBID,
  member: MemberSummary,
  whenCreated: Time,
  whenUpdated: Time,
  commentLbml: Option[String],
  removedByAdmin: Boolean,
  deleted: Boolean,
  blocked: Boolean,
  blockedByOwner: Boolean,
  editableWindowExpiresIn: Option[Int],
  list: ListIdentifier,
  comment: Option[String]
) extends AbstractComment

case class ReviewComment(
  id: LBID,
  member: MemberSummary,
  whenCreated: Time,
  whenUpdated: Time,
  commentLbml: Option[String],
  removedByAdmin: Boolean,
  deleted: Boolean,
  blocked: Boolean,
  blockedByOwner: Boolean,
  editableWindowExpiresIn: Option[Int],
  review: ReviewIdentifier,
  comment: Option[String]
) extends AbstractComment

object AbstractComment {
  import play.api.libs.functional.syntax._

  private val reads: Reads[AbstractComment] = Reads.of[JsObject].flatMap[AbstractComment](
    _.value("type").as[String] match {
      case "ListComment" => ListComment.format.map(identity)
      case "ReviewComment" => ReviewComment.format.map(identity)
    }
  )

  private val writes: Writes[AbstractComment] = Writes.of[JsValue].contramap[AbstractComment]({
    case l: ListComment   => Json.toJson(l)
    case r: ReviewComment => Json.toJson(r)
  })

  implicit val format: Format[AbstractComment] = Format(reads, writes)
}

object ListComment {
  implicit val format: Format[ListComment] = Json.format[ListComment]
}

object ReviewComment {
  implicit val format: Format[ReviewComment] = Json.format[ReviewComment]
}
