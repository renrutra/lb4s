package lb4s.primitive

import play.api.libs.json.Format

/**
  * A unique identifier for Letterboxd entities.
  * @param id the alphanumeric string value
  */
case class LBID(id: String) {
  override def toString: String = id
}

object LBID {
  import play.api.libs.functional.syntax._

  implicit val format: Format[LBID] = Format.of[String].inmap(LBID(_), _.id)
}
