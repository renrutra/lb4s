package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param watched true for "watched" or false for "not watched"
  * @param liked true for "liked" or false for "not liked"
  * @param inWatchlist true to add the film to the authenticated member's watchlist, or false to remove it
  * @param rating a rating between 0.5 and 5.0, with increments of 0.5
  */
case class FilmRelationshipUpdateRequest(
  watched: Option[Boolean],
  liked: Option[Boolean],
  inWatchlist: Option[Boolean],
  rating: Option[String]
)

object FilmRelationshipUpdateRequest {
  implicit val format: Format[FilmRelationshipUpdateRequest] = Json.format[FilmRelationshipUpdateRequest]
}
