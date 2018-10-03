package lb4s.primitive

import play.api.libs.json.Format

object MemberRelationshipType extends Enumeration {
  import play.api.libs.functional.syntax._

  val Released, NotReleased, InWatchlist, NotInWatchlist, Watched, NotWatched, FeatureLength, NotFeatureLength = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
