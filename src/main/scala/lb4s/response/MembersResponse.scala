package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of members
  */
case class MembersResponse(next: Option[Cursor], items: List[MemberSummary])

object MembersResponse {
  implicit val format: Format[MembersResponse] = Json.format[MembersResponse]
}
