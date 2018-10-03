package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param rank if the list is ranked, the entry's rank in the list, numbered from 1
  * @param notesLbml the notes for the list entry in LBML
  * @param containsSpoilers true if the member has indicated that the notes field contains plot spoilers for the film
  * @param film the film for this entry
  * @param notes the notes for the list entry formatted as HTML
  */
case class ListEntry(
  rank: Option[Int],
  notesLbml: Option[String],
  containsSpoilers: Option[Boolean],
  film: FilmSummary,
  notes: Option[String]
)

object ListEntry {
  implicit val format: Format[ListEntry] = Json.format[ListEntry]
}
