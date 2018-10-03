package lb4s.response

import play.api.libs.json.{Format, Json}

case class AFilmsMetadata(totalFilmCount: Int, filteredFilmCount: Int)

object AFilmsMetadata {
  implicit val format: Format[AFilmsMetadata] = Json.format[AFilmsMetadata]
}
