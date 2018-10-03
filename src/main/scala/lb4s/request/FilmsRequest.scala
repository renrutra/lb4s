package lb4s.request

import lb4s.primitive.{Cursor, FilmFilterType, FilmRelationshipType, IncludeType, LBID}
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param sort the order in which the films should be returned
  * @param filmId up to 100 Letterboxd IDs, or TMDb IDs prefixed with "tmdb:", or IMDb IDs prefixed with "imdb:"
  * @param genre the LBID of a genre to limit films to those within the specified genre
  * @param decade the starting year of a decade to limit films to those released during the decade
  * @param year a year to limit films to those released during that year
  * @param service the ID of a supported service to limit films to those available from that service
  * @param where one or more filter types to limit the list of films accordingly
  * @param member the LBID of a member to limit the returned films according to the value set in memberRelationship or
  *               to access the MemberRatingHighToLow and MemberRatingLowToHigh sort options
  * @param memberRelationship the type of relationship to limit the returned films accordingly,
  *                           used in conjunction with member
  * @param includeFriends specifies how to filter films based on the member specified by member
  * @param tagCode a tag code to limit the returned films to those tagged accordingly
  * @param tagger the LBID of a member to focus the tag filter, used with tagCode
  * @param includeTaggerFriends specifies how to filter tags based on the member specified by tagger
  */
case class FilmsRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  sort: String = "FilmPopularity",
  filmId: List[String] = Nil,
  genre: Option[String] = None,
  decade: Option[Int] = None,
  year: Option[Int] = None,
  service: Option[String] = None,
  where: List[FilmFilterType.Value] = Nil,
  member: Option[LBID] = None,
  memberRelationship: Option[FilmRelationshipType.Value] = None,
  includeFriends: Option[IncludeType.Value] = None,
  tagCode: Option[String] = None,
  tagger: Option[LBID] = None,
  includeTaggerFriends: Option[IncludeType.Value] = None
)

object FilmsRequest {
  implicit val format: Format[FilmsRequest] = Json.format[FilmsRequest]
}
