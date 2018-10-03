package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param comments the number of comments for the review
  * @param likes the number of members who like the review
  */
case class ReviewStatisticsCounts(comments: Int, likes: Int)

object ReviewStatisticsCounts {
  implicit val format: Format[ReviewStatisticsCounts] = Json.format[ReviewStatisticsCounts]
}
