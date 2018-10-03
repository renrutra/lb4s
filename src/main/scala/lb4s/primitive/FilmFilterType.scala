package lb4s.primitive

import play.api.libs.json.Format

object FilmFilterType extends Enumeration {
  import play.api.libs.functional.syntax._

  val Released, NotReleased, InWatchlist, NotInWatchlist, WatchedFromWatchlist, Watched, NotWatched, FeatureLength, NotFeatureLength = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
