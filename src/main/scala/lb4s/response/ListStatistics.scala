package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param list the list for which statistics were requested
  * @param counts the number of comments and likes for the list
  */
case class ListStatistics(list: ListIdentifier, counts: ListStatisticsCounts)

object ListStatistics {
  implicit val format: Format[ListStatistics] = Json.format[ListStatistics]
}
