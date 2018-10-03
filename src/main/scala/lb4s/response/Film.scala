package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the film
  * @param name the title of the film
  * @param originalName the original title of the film, if it was first released with a non-English title
  * @param alternativeNames the other names by which the film is known
  * @param releaseYear the year in which the film was first released
  * @param tagline the tagline for the film
  * @param description a synopsis of the film
  * @param runTime the film's duration, in minutes
  * @param poster the film's poster image
  * @param backdrop the film's backdrop image
  * @param backdropFocalPoint the backdrop's vertical focal point, expressed as a proportion of the image's height
  * @param trailer the film's trailer
  * @param genres the film's genres
  * @param contributions the film's contributors (director, cast and crew) grouped by discipline.
  * @param filmCollectionId the LBID of the collection containing this film
  * @param links a list of relevant URLs for this entity, on Letterboxd and external sites
  */
case class Film(
  id: LBID,
  name: String,
  originalName: Option[String],
  alternativeNames: Option[List[String]],
  releaseYear: Option[Int],
  tagline: Option[String],
  description: Option[String],
  runTime: Option[Int],
  poster: Option[Image],
  backdrop: Option[Image],
  backdropFocalPoint: Option[Double],
  trailer: Option[FilmTrailer],
  genres: List[Genre],
  contributions: List[FilmContributions],
  filmCollectionId: Option[LBID],
  links: List[Link]
)

object Film {
  implicit val format: Format[Film] = Json.format[Film]
}
