package lb4s.request

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param published true if the owner has elected to publish the list for other members to see
  * @param name the name of the list
  * @param ranked true if the owner has elected to make this a ranked list
  * @param description the list description in LBML
  * @param tags the tags for the list
  * @param filmsToRemove the LBIDs of films to be removed from the list
  * @param entries the specified entries that will be appended or updated
  * @param share the third-party services to which this list should be shared
  */
case class ListUpdateRequest(
  published: Option[Boolean] = None,
  name: Option[String] = None,
  ranked: Option[Boolean] = None,
  description: Option[String] = None,
  tags: Option[List[String]] = None,
  filmsToRemove: List[LBID] = Nil,
  entries: List[ListUpdateEntry] = Nil,
  share: Option[List[String]] = None
)

object ListUpdateRequest {
  implicit val format: Format[ListUpdateRequest] = Json.format[ListUpdateRequest]
}
