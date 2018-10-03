package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param member the member
  * @param relationships the relationship details
  */
case class FilmContributorMemberRelationship(member: MemberSummary, relationships: List[FilmContributorRelationship])

object FilmContributorMemberRelationship {
  implicit val format: Format[FilmContributorMemberRelationship] = Json.format[FilmContributorMemberRelationship]
}
