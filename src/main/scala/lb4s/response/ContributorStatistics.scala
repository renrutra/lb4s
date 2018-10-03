package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param contributions the statistics for each contribution type
  */
case class ContributorStatistics(contributions: List[ContributionStatistics])

object ContributorStatistics {
  implicit val format: Format[ContributorStatistics] = Json.format[ContributorStatistics]
}
