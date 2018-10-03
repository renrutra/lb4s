package lb4s.response

import lb4s.primitive.{LBID, Time}
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the list
  * @param name the name of the list
  * @param filmCount the number of films in the list
  * @param published true if the owner has elected to publish the list for other members to see
  * @param ranked true if the owner has elected to make this a ranked list
  * @param hasEntriesWithNotes true if the owner has added notes to any entries
  * @param descriptionLbml the list description in LBML
  * @param tags2 the tags for the list
  * @param canShareOn the third-party services to which this list can be shared
  * @param sharedOn the third-party services to which this list has been shared
  * @param whenCreated the time when the list was created
  * @param whenPublished the time when the list was published
  * @param owner the member who owns the list
  * @param clonedFrom the list this was cloned from
  * @param previewEntries the first 12 entries in the list
  * @param links a list of relevant URLs for this entity, on Letterboxd and external sites
  * @param description the list description formatted as HTML
  */
case class FilmList(
  id: LBID,
  name: String,
  filmCount: Int,
  published: Boolean,
  ranked: Boolean,
  hasEntriesWithNotes: Boolean,
  descriptionLbml: Option[String],
  tags2: Option[List[Tag]],
  canShareOn: Option[List[String]],
  sharedOn: Option[List[String]],
  whenCreated: Time,
  whenPublished: Option[Time],
  owner: MemberSummary,
  clonedFrom: Option[ListIdentifier],
  previewEntries: List[ListEntrySummary],
  links: List[Link],
  description: Option[String]
)

object FilmList {
  implicit val format: Format[FilmList] = Json.format[FilmList]
}
