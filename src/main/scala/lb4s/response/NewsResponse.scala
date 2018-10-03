package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of news items
  */
case class NewsResponse(next: Option[Cursor], items: List[NewsItem])

object NewsResponse {
  implicit val format: Format[NewsResponse] = Json.format[NewsResponse]
}
