package lb4s.response

import play.api.libs.json.{Format, Json}

case class FilmsRelationshipCounts(watches: Int, likes: Int)

object FilmsRelationshipCounts {
  implicit val format: Format[FilmsRelationshipCounts] = Json.format[FilmsRelationshipCounts]
}
