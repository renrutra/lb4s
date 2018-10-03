package lb4s.request

import lb4s.primitive.{Cursor, FilmRelationshipType, IncludeType, LBID}
import play.api.libs.json.{Format, JsPath}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param sort the order in which the log entries should be returned
  * @param film the LBID of a film to return log entries for that film
  * @param member the LBID of a member to limit the returned log entries according to the value set in memberRelationship
  *               or to access the MemberRatingHighToLow and MemberRatingLowToHigh sort options
  * @param memberRelationship limit the returned log entries, used in conjunction with member
  * @param filmMemberRelationship the type of relationship to limit the returned films accordingly,
  *                               used in conjunction with member
  * @param includeFriends specifies how to filter log entries based on the member specified by member
  * @param year limits the returned log entries to those with date that falls during the specified year
  * @param month limits the returned log entries to those with a date that falls during the specified month and year
  * @param week limits the returned log entries to those with a date that falls during the specified week and year
  * @param day limits the returned log entries to those with a date that falls on the specified day, month, and year
  * @param minRating limits the returned log entries to those with a rating equal to or higher than the specified rating
  * @param maxRating limits the returned log entries to those with a rating equal to or lower than the specified rating
  * @param filmDecade the starting year of a decade to limit films to those released during the decade
  * @param filmYear a year to limit films to those released during that year
  * @param genre the LBID of a genre to limit the returned log entries to those for films that match the specified genre
  * @param tagCode a tag code to limit the returned log entries to those tagged accordingly
  * @param tagger the LBID of a member to focus the tag filter on the member, used with tagCode
  * @param includeTaggerString specifies how to filter tags based on the member specified by tagger
  * @param service the ID of a supported service to limit films to those available from that service
  * @param where one or more filter types to limit the search results accordingly
  * @param filter one or more filter types to limit the search results accordingly
  */
case class LogEntriesRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  sort: String = "WhenAdded",
  film: Option[LBID] = None,
  member: Option[LBID] = None,
  memberRelationship: Option[String] = None,
  filmMemberRelationship: Option[FilmRelationshipType.Value] = None,
  includeFriends: Option[IncludeType.Value] = None,
  year: Option[Int] = None,
  month: Option[Int] = None,
  week: Option[Int] = None,
  day: Option[Int] = None,
  minRating: Option[Double] = None,
  maxRating: Option[Double] = None,
  filmDecade: Option[Int] = None,
  filmYear: Option[Int] = None,
  genre: Option[String] = None,
  tagCode: Option[String] = None,
  tagger: Option[LBID] = None,
  includeTaggerString: Option[IncludeType.Value] = None,
  service: Option[String] = None,
  where: List[String] = Nil,
  filter: List[String] = Nil
)

object LogEntriesRequest {
  import play.api.libs.functional.syntax._

  private val searchFormat = (
    (JsPath \ "cursor").formatNullable[Cursor] and
    (JsPath \ "perPage").format[Int] and
    (JsPath \ "sort").format[String]
  ).tupled

  private val filterFormat = (
    (JsPath \ "film").formatNullable[LBID] and
    (JsPath \ "member").formatNullable[LBID] and
    (JsPath \ "memberRelationship").formatNullable[String] and
    (JsPath \ "filmMemberRelationship").formatNullable[FilmRelationshipType.Value] and
    (JsPath \ "includeFriends").formatNullable[IncludeType.Value] and
    (JsPath \ "year").formatNullable[Int] and
    (JsPath \ "month").formatNullable[Int] and
    (JsPath \ "week").formatNullable[Int] and
    (JsPath \ "day").formatNullable[Int] and
    (JsPath \ "minRating").formatNullable[Double] and
    (JsPath \ "maxRating").formatNullable[Double] and
    (JsPath \ "filmDecade").formatNullable[Int] and
    (JsPath \ "filmYear").formatNullable[Int] and
    (JsPath \ "genre").formatNullable[String] and
    (JsPath \ "tagCode").formatNullable[String] and
    (JsPath \ "tagger").formatNullable[LBID] and
    (JsPath \ "includeTaggerString").formatNullable[IncludeType.Value] and
    (JsPath \ "service").formatNullable[String] and
    (JsPath \ "where").format[List[String]] and
    (JsPath \ "filter").format[List[String]]
  ).tupled

  implicit val format: Format[LogEntriesRequest] = (searchFormat and filterFormat)(
    { case (s, f) =>
      LogEntriesRequest(s._1, s._2, s._3, f._1, f._2, f._3, f._4, f._5, f._6, f._7, f._8, f._9, f._10, f._11, f._12, f._13, f._14, f._15, f._16, f._17, f._18, f._19)
    },
    req => (
      (
        req.cursor,
        req.perPage,
        req.sort
      ),
      (
        req.film,
        req.member,
        req.memberRelationship,
        req.filmMemberRelationship,
        req.includeFriends,
        req.year,
        req.month,
        req.week,
        req.day,
        req.minRating,
        req.maxRating,
        req.filmDecade,
        req.filmYear,
        req.genre,
        req.tagCode,
        req.tagger,
        req.includeTaggerString,
        req.service,
        req.where,
        req.filter
      )
    )
  )
}
