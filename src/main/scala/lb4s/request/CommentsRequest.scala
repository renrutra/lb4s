package lb4s.request

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param sort the order in which the comments should be returned
  * @param includeDeletions true to discover any comments that were deleted
  */
case class CommentsRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  sort: String = "Date",
  includeDeletions: Boolean = false
)

object CommentsRequest {
  implicit val format: Format[CommentsRequest] = Json.format[CommentsRequest]
}
