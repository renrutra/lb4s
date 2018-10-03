package lb4s.request

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  */
case class NewsRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20
)

object NewsRequest {
  implicit val format: Format[NewsRequest] = Json.format[NewsRequest]
}
