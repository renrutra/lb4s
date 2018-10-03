package lb4s.response

import lb4s.primitive.{LBID, Time}
import play.api.libs.json.{Format, Json}

/**
  * @param watched true if the member has indicated they've seen the film
  * @param whenWatched the time when the member marked the film as watched
  * @param liked true if the member likes the film
  * @param whenLiked the time when the member marked the film as liked
  * @param favorited true if the member listed the film as one of their four favorites
  * @param inWatchlist true if the film is in the member's watchlist
  * @param whenAddedToWatchlist the time when the member added the film to their watchlist
  * @param whenCompletedInWatchlist the time when the member marked the film as watched, if the member used to
  *                                 have the film in their watchlist, and subsequently watched the film
  * @param rating the member's rating for the film
  * @param reviews a list of LBIDs for reviews the member has written for the film in the order they were added
  * @param diaryEntries a list of LBIDs for log entries the member has added for the film in diary order
  */
case class FilmRelationship(
  watched: Boolean,
  whenWatched: Option[Time],
  liked: Boolean,
  whenLiked: Option[Time],
  favorited: Boolean,
  inWatchlist: Option[Boolean],
  whenAddedToWatchlist: Option[Time],
  whenCompletedInWatchlist: Option[Time],
  rating: Option[Double],
  reviews: Option[List[LBID]],
  diaryEntries: Option[List[LBID]]
)

object FilmRelationship {
  implicit val format: Format[FilmRelationship] = Json.format[FilmRelationship]
}
