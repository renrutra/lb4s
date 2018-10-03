package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the member
  * @param username the member's Letterboxd username
  * @param givenName the given name of the member
  * @param familyName the family name of the member
  * @param displayName the member's given name and family name, or their username if neither is set
  * @param shortName the member's given name, if set, or their username
  * @param pronoun the member's preferred pronoun
  * @param avatar the member's avatar image
  * @param memberStatus the member's account type
  */
case class MemberSummary(
  id: LBID,
  username: String,
  givenName: Option[String],
  familyName: Option[String],
  displayName: Option[String],
  shortName: String,
  pronoun: Pronoun,
  avatar: Image,
  memberStatus: String
)

object MemberSummary {
  implicit val format: Format[MemberSummary] = Json.format[MemberSummary]
}
