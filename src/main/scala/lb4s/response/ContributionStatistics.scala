package lb4s.response

import lb4s.primitive.FilmContributionType
import play.api.libs.json.{Format, Json}

/**
  * @param type the type of contribution
  * @param filmCount the number of films for this contribution type
  */
case class ContributionStatistics(`type`: FilmContributionType.Value, filmCount: Int)

object ContributionStatistics {
  implicit val format: Format[ContributionStatistics] = Json.format[ContributionStatistics]
}
