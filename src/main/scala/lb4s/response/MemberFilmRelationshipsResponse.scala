package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of film relationships for members
  */
case class MemberFilmRelationshipsResponse(next: Option[Cursor], items: List[MemberFilmRelationship])

object MemberFilmRelationshipsResponse {
  implicit val format: Format[MemberFilmRelationshipsResponse] = Json.format[MemberFilmRelationshipsResponse]
}
