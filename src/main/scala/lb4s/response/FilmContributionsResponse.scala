package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of contributions
  * @param metadata metadata about the contributor's contributions
  * @param relationships the relationships to the contributor for the members referenced in the request
  */
case class FilmContributionsResponse(
  next: Option[Cursor],
  items: List[FilmContribution],
  metadata: List[AFilmContributorMetadata],
  relationships: Option[List[FilmContributorMemberRelationship]]
)

object FilmContributionsResponse {
  implicit val format: Format[FilmContributionsResponse] = Json.format[FilmContributionsResponse]
}
