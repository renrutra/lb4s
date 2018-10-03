package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the list
  * @param name the name of the list
  * @param filmCount the number of films in the list
  * @param published true if the owner has elected to publish the list for other members to see
  * @param ranked true if the owner has elected to make this a ranked list
  * @param descriptionLbml the list description in LBML
  * @param descriptionTruncated true if the list description was truncated because it's very long
  * @param owner the member who owns the list
  * @param clonedFrom the list this was cloned from
  * @param previewEntries the first 12 entries in the list
  * @param description the list description formatted as HTML
  */
case class ListSummary(
  id: LBID,
  name: String,
  filmCount: Int,
  published: Boolean,
  ranked: Boolean,
  descriptionLbml: Option[String],
  descriptionTruncated: Option[Boolean],
  owner: MemberSummary,
  clonedFrom: Option[ListIdentifier],
  previewEntries: List[ListEntrySummary],
  description: Option[String]
)

object ListSummary {
  implicit val format: Format[ListSummary] = Json.format[ListSummary]
}
