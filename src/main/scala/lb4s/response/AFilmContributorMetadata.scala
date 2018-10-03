package lb4s.response

import lb4s.primitive.FilmContributionType
import play.api.libs.json.{Format, Json}

/**
  * @param type the type of contribution
  * @param data the details for this contribution type
  */
case class AFilmContributorMetadata(`type`: FilmContributionType.Value, data: AFilmsMetadata)

object AFilmContributorMetadata {
  implicit val format: Format[AFilmContributorMetadata] = Json.format[AFilmContributorMetadata]
}
