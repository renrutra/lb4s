package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param service the service
  * @param displayName the service's name
  * @param country the regional store for the service
  * @param id the unique ID for the film on the store
  * @param url the fully qualified URL for the film on this store
  */
case class FilmAvailability(service: String, displayName: String, country: String, id: Option[String], url: String)

object FilmAvailability {
  implicit val format: Format[FilmAvailability] = Json.format[FilmAvailability]
}
