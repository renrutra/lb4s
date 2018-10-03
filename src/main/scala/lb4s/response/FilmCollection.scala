package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the film collection
  * @param name the name of the collection
  * @param films the list of films in the collection
  * @param links a list of relevant URLs for this entity, on Letterboxd and external sites
  */
case class FilmCollection(id: LBID, name: String, films: List[FilmSummary], links: List[Link])

object FilmCollection {
  implicit val format: Format[FilmCollection] = Json.format[FilmCollection]
}
