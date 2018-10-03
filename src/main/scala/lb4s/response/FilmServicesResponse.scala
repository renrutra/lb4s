package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param items the list of film services
  */
case class FilmServicesResponse(items: List[Service])

object FilmServicesResponse {
  implicit val format: Format[FilmServicesResponse] = Json.format[FilmServicesResponse]
}
