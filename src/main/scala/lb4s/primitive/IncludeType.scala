package lb4s.primitive

import play.api.libs.json.Format

object IncludeType extends Enumeration {
  import play.api.libs.functional.syntax._

  val None, All, Only = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
