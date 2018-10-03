package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param member the member
  * @param relationship the relationship details
  */
case class FilmsMemberRelationship(member: MemberSummary, relationship: FilmsRelationship)

object FilmsMemberRelationship {
  implicit val format: Format[FilmsMemberRelationship] = Json.format[FilmsMemberRelationship]
}
