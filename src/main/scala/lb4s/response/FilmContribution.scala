package lb4s.response

import lb4s.primitive.FilmContributionType
import play.api.libs.json.{Format, Json}

/**
  * @param type the type of contribution
  * @param film the film
  * @param characterName the name of the character (only when type is Actor)
  */
case class FilmContribution(`type`: FilmContributionType.Value, film: FilmSummary, characterName: Option[String])

object FilmContribution {
  implicit val format: Format[FilmContribution] = Json.format[FilmContribution]
}
