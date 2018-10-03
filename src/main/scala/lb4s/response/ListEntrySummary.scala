package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param rank if the list is ranked, the entry's rank in the list, numbered from 1
  * @param film the film for this entry
  */
case class ListEntrySummary(rank: Option[Int], film: FilmSummary)

object ListEntrySummary {
  implicit val format: Format[ListEntrySummary] = Json.format[ListEntrySummary]
}
