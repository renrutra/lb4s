package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the genre
  * @param name the name of the genre
  */
case class Genre(id: LBID, name: String)

object Genre {
  implicit val format: Format[Genre] = Json.format[Genre]
}
