package lb4s.request

import lb4s.primitive.{Cursor, IncludeType, LBID}
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param sort the order in which the lists should be returned
  * @param film the LBID of a film to return lists that include that film
  * @param clonedFrom the LBID of a list to return lists that were cloned from that list
  * @param tagCode a tag code to limit the returned lists to those tagged accordingly
  * @param tagger the LBID of a member to focus the tag filter on the member, used with tagCode
  * @param includeTaggerFriends specifies how to filter tags based on the member specified by tagger
  * @param member the LBID of a member to return lists that are owned or liked by the member
  * @param memberRelationship the type of relationship to limit the returned lists accordingly,
  *                           used in conjunction with member
  * @param includeFriends specifies how to filter lists based on the member specified by member
  * @param where one or more filter types to limit the search results accordingly
  * @param filter one or more filter types to limit the search results accordingly
  */
case class ListsRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  sort: String = "Date",
  film: Option[LBID] = None,
  clonedFrom: Option[LBID] = None,
  tagCode: Option[String] = None,
  tagger: Option[LBID] = None,
  includeTaggerFriends: Option[IncludeType.Value] = None,
  member: Option[LBID] = None,
  memberRelationship: Option[String] = None,
  includeFriends: Option[IncludeType.Value] = None,
  where: List[String] = Nil,
  filter: List[String] = Nil
)

object ListsRequest {
  implicit val format: Format[ListsRequest] = Json.format[ListsRequest]
}
