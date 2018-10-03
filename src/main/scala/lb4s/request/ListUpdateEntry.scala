package lb4s.request

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param film the LBID of the film
  * @param rank if the list is ranked, the entry's rank in the list, numbered from 1
  * @param notes the notes for the list entry in LBML
  * @param containsSpoilers true if the member has indicated that the notes field contains plot spoilers for the film
  */
case class ListUpdateEntry(
  film: LBID,
  rank: Option[Int] = None,
  notes: Option[String] = None,
  containsSpoilers: Option[Boolean] = None
)

object ListUpdateEntry {
  implicit val format: Format[ListUpdateEntry] = Json.format[ListUpdateEntry]
}
