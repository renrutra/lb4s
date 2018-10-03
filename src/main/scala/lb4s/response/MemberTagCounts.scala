package lb4s.response

import play.api.libs.json.{Format, Json}

case class MemberTagCounts(films: Int, logEntries: Int, diaryEntries: Int, reviews: Int, lists: Int)

object MemberTagCounts {
  implicit val format: Format[MemberTagCounts] = Json.format[MemberTagCounts]
}
