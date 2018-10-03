package lb4s.response

import lb4s.primitive.FilmContributionType
import play.api.libs.json.{Format, Json}

/**
  * @param type the type of contribution
  * @param relationship the relationship the member has with the (filtered) films
  */
case class FilmContributorRelationship(`type`: FilmContributionType.Value, relationship: FilmsRelationship)

object FilmContributorRelationship {
  implicit val format: Format[FilmContributorRelationship] = Json.format[FilmContributorRelationship]
}
