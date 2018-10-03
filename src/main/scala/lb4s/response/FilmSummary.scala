package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the film
  * @param name the title of the film
  * @param originalName the original title of the film, if it was first released with a non-English title
  * @param alternativeNames the other names by which the film is known
  * @param releaseYear the year in which the film was first released
  * @param directors the list of directors for the film
  * @param poster the film's poster image
  * @param filmCollectionId the LBID of the collection containing this film
  * @param links a list of relevant URLs for this entity, on Letterboxd and external sites
  * @param relationships relationships to the film for the authenticated member and other members where relevant
  */
case class FilmSummary(
  id: LBID,
  name: String,
  originalName: Option[String],
  alternativeNames: Option[List[String]],
  releaseYear: Option[Int],
  directors: Option[List[ContributorSummary]],
  poster: Option[Image],
  filmCollectionId: Option[LBID],
  links: List[Link],
  relationships: Option[List[MemberFilmRelationship]]
)

object FilmSummary {
  implicit val format: Format[FilmSummary] = Json.format[FilmSummary]
}
