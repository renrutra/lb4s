package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the contributor
  * @param name the name of the contributor
  * @param statistics a list of the types of contributions made, with a count of films for each contribution type
  * @param links a list of relevant URLs for this entity, on Letterboxd and external sites
  */
case class Contributor(id: LBID, name: String, statistics: ContributorStatistics, links: List[Link])

object Contributor {
  implicit val format: Format[Contributor] = Json.format[Contributor]
}
