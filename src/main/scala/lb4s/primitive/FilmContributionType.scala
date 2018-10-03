package lb4s.primitive

import play.api.libs.json.Format

object FilmContributionType extends Enumeration {
  import play.api.libs.functional.syntax._

  val Director, Actor, Producer, Writer, Editor, Cinematography, ArtDirection, VisualEffects, Composer, Sound, Costumes, MakeUp, Studio = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
