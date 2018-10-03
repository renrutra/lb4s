package lb4s.request

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param include specifies the subset of activity to be returned
  * @param where reduces the subset of activity to be returned
  */
case class ActivityRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  include: List[String] = Nil,
  where: List[String] = Nil
)

object ActivityRequest {
  implicit val format: Format[ActivityRequest] = Json.format[ActivityRequest]
}
