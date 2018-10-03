package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param logEntry the log entry for which statistics were requested
  * @param counts the number of comments and likes for the review
  */
case class ReviewStatistics(logEntry: ReviewIdentifier, counts: ReviewStatisticsCounts)

object ReviewStatistics {
  implicit val format: Format[ReviewStatistics] = Json.format[ReviewStatistics]
}
