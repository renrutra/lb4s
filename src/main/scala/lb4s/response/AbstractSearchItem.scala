package lb4s.response

import play.api.libs.json.{Format, JsObject, Json, JsString, JsValue, Reads, Writes}

sealed trait AbstractSearchItem {
  def `type`: String
  def score: Double
}

case class ContributorSearchItem(`type`: String, score: Double, contributor: Contributor) extends AbstractSearchItem
case class FilmSearchItem(`type`: String, score: Double, film: FilmSummary) extends AbstractSearchItem
case class ListSearchItem(`type`: String, score: Double, list: ListSummary) extends AbstractSearchItem
case class MemberSearchItem(`type`: String, score: Double, member: MemberSummary) extends AbstractSearchItem
case class ReviewSearchItem(`type`: String, score: Double, review: LogEntry) extends AbstractSearchItem
case class TagSearchItem(`type`: String, score: Double, tag: String) extends AbstractSearchItem

object AbstractSearchItem {
  import play.api.libs.functional.syntax._

  private val contributorFormat = Json.format[ContributorSearchItem]
  private val filmFormat = Json.format[FilmSearchItem]
  private val listFormat = Json.format[ListSearchItem]
  private val memberFormat = Json.format[MemberSearchItem]
  private val reviewFormat = Json.format[ReviewSearchItem]
  private val tagFormat = Json.format[TagSearchItem]

  private val reads: Reads[AbstractSearchItem] = Reads.of[JsObject].flatMap[AbstractSearchItem](
    _.value("type").as[String] match {
      case "ContributorSearchItem" => contributorFormat.map(identity)
      case "FilmSearchItem"        => filmFormat       .map(identity)
      case "ListSearchItem"        => listFormat       .map(identity)
      case "MemberSearchItem"      => memberFormat     .map(identity)
      case "ReviewSearchItem"      => reviewFormat     .map(identity)
      case "TagSearchItem"         => tagFormat        .map(identity)
    }
  )

  private val writes: Writes[AbstractSearchItem] = Writes.of[JsValue].contramap[AbstractSearchItem]({
    case i: ContributorSearchItem => Json.toJson(i)
    case i: FilmSearchItem        => Json.toJson(i)
    case i: ListSearchItem        => Json.toJson(i)
    case i: MemberSearchItem      => Json.toJson(i)
    case i: ReviewSearchItem      => Json.toJson(i)
    case i: TagSearchItem         => Json.toJson(i)
  })

  implicit val format: Format[AbstractSearchItem] = Format(reads, writes)
}
