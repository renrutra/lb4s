package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of lists
  */
case class ListsResponse(next: Option[Cursor], items: List[ListSummary])

object ListsResponse {
  implicit val format: Format[ListsResponse] = Json.format[ListsResponse]
}
