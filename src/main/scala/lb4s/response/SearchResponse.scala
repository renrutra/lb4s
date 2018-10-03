package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of search results
  */
case class SearchResponse(next: Option[Cursor], items: List[AbstractSearchItem])

object SearchResponse {
  implicit val format: Format[SearchResponse] = Json.format[SearchResponse]
}
