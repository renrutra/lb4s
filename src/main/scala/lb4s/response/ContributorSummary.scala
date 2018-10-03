package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the contributor
  * @param name the name of the contributor
  * @param characterName the character name if available (only if the contribution is as an Actor)
  */
case class ContributorSummary(id: LBID, name: String, characterName: Option[String])

object ContributorSummary {
  implicit val format: Format[ContributorSummary] = Json.format[ContributorSummary]
}
