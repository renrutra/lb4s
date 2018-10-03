package lb4s.response

import lb4s.primitive.FilmContributionType
import play.api.libs.json.{Format, Json}

/**
  * @param type the type of contribution
  * @param contributors the list of contributors of the specified type for the film
  */
case class FilmContributions(`type`: FilmContributionType.Value, contributors: List[ContributorSummary])

object FilmContributions {
  implicit val format: Format[FilmContributions] = Json.format[FilmContributions]
}
