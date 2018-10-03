package lb4s.primitive

import play.api.libs.json.Format

/**
  * A Cursor stores a string value provided by the API. It should be treated as an opaque value.
  * @param value the string value
  */
case class Cursor(value: String)

object Cursor {
  import play.api.libs.functional.syntax._

  implicit val format: Format[Cursor] = Format.of[String].inmap(Cursor(_), _.value)
}
