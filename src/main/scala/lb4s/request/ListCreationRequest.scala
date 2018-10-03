package lb4s.request

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param published true if the owner has elected to publish the list for other members to see
  * @param name the name of the list
  * @param ranked true if the owner has elected to make this a ranked list
  * @param description the list description in LBML
  * @param clonedFrom the LBID of a list to clone from
  * @param tags the tags for the list
  * @param entries the films that comprise the list
  * @param share the third-party services to which this list should be shared
  */
case class ListCreationRequest(
  published: Boolean,
  name: String,
  ranked: Boolean,
  description: Option[String] = None,
  clonedFrom: Option[LBID] = None,
  tags: List[String] = Nil,
  entries: List[ListCreateEntry],
  share: List[String] = Nil
)

object ListCreationRequest {
  implicit val format: Format[ListCreationRequest] = Json.format[ListCreationRequest]
}
