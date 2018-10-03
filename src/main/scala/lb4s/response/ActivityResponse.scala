package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of activity items
  */
case class ActivityResponse(next: Option[Cursor], items: List[AbstractActivity])

object ActivityResponse {
  implicit val format: Format[ActivityResponse] = Json.format[ActivityResponse]
}
