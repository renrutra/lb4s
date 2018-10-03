package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param member the member for which statistics were requested
  * @param counts the number of watches, ratings, likes, etc. for the member
  * @param ratingsHistogram a summary of the number of ratings the member has made
  * @param yearsInReview a list of years the member has year-in-review pages for
  */
case class MemberStatistics(
  member: MemberIdentifier,
  counts: MemberStatisticsCounts,
  ratingsHistogram: List[RatingsHistogramBar],
  yearsInReview: List[Int]
)

object MemberStatistics {
  implicit val format: Format[MemberStatistics] = Json.format[MemberStatistics]
}
