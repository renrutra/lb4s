package lb4s.request

import lb4s.primitive.{Cursor, FilmRelationshipType, LBID}
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param sort the order in which the members should be returned
  * @param member the LBID of a member to return members who follow or are followed by that member
  * @param memberRelationship the type of relationship to limit the returned films accordingly,
  *                           used in conjunction with member
  * @param film the LBID of a film to return members who have interacted with that film
  * @param filmRelationship the type of relationship to limit the returned members accordingly,
  *                         used in conjunction with film
  * @param list the LBID of a list to return members who like that list
  * @param review tthe LBID of a review to return members who like that review
  */
case class MembersRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  sort: String = "Date",
  member: Option[LBID] = None,
  memberRelationship: Option[String] = None,
  film: Option[LBID] = None,
  filmRelationship: Option[FilmRelationshipType.Value] = None,
  list: Option[LBID] = None,
  review: Option[LBID] = None
)

object MembersRequest {
  implicit val format: Format[MembersRequest] = Json.format[MembersRequest]
}
