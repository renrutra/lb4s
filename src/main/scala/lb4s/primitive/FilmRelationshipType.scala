package lb4s.primitive

import play.api.libs.json.Format

object FilmRelationshipType extends Enumeration {
  import play.api.libs.functional.syntax._

  val Ignore, Watched, NotWatched, Liked, NotLiked, InWatchlist, NotInWatchlist, Favorited = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
