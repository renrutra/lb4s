package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of entries
  * @param metadata the filtered and total count of films in the list
  * @param relationships the relationships to the films in the list for the members referenced in the request
  */
case class ListEntriesResponse(
  next: Option[Cursor],
  items: List[ListEntry],
  metadata: AFilmsMetadata,
  relationships: List[FilmsMemberRelationship]
)

object ListEntriesResponse {
  implicit val format: Format[ListEntriesResponse] = Json.format[ListEntriesResponse]
}
