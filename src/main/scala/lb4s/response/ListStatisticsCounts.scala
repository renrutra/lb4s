package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param comments the number of comments for the list
  * @param likes the number of members who like the list
  */
case class ListStatisticsCounts(comments: Int, likes: Int)

object ListStatisticsCounts {
  implicit val format: Format[ListStatisticsCounts] = Json.format[ListStatisticsCounts]
}
