package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param member the member
  * @param relationship the relationship details
  */
case class MemberFilmRelationship(member: MemberSummary, relationship: FilmRelationship)

object MemberFilmRelationship {
  implicit val format: Format[MemberFilmRelationship] = Json.format[MemberFilmRelationship]
}
