package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of comments
  */
case class ListCommentsResponse(next: Option[Cursor], items: List[ListComment])

object ListCommentsResponse {
  implicit val format: Format[ListCommentsResponse] = Json.format[ListCommentsResponse]
}
