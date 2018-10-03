package lb4s.request

import lb4s.primitive.{Cursor, FilmRelationshipType, LBID}
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param sort the order in which the film relationships should be returned
  * @param member the LBID of a member to return members who follow or are followed by that member
  * @param memberRelationship the type of relationship to limit the returned film relationships accordingly,
  *                           used in conjunction with member
  * @param filmRelationship the type of relationship to limit the returned members accordingly,
  *                         used in conjunction with film
  */
case class MemberFilmRelationshipsRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  sort: String = "Date",
  member: Option[LBID] = None,
  memberRelationship: Option[String] = None,
  filmRelationship: Option[FilmRelationshipType.Value] = None
)

object MemberFilmRelationshipsRequest {
  implicit val format: Format[MemberFilmRelationshipsRequest] = Json.format[MemberFilmRelationshipsRequest]
}
