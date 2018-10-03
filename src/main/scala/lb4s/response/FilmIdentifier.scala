package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the film
  */
case class FilmIdentifier(id: LBID)

object FilmIdentifier {
  implicit val format: Format[FilmIdentifier] = Json.format[FilmIdentifier]
}
