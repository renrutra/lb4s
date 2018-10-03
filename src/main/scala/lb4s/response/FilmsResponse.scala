package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of films
  */
case class FilmsResponse(next: Option[Cursor], items: List[FilmSummary])

object FilmsResponse {
  implicit val format: Format[FilmsResponse] = Json.format[FilmsResponse]
}
