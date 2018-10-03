package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param items the list of stores where the film is available for streaming or purchasing, in order of preference
  */
case class FilmAvailabilityResponse(items: List[FilmAvailability])

object FilmAvailabilityResponse {
  implicit val format: Format[FilmAvailabilityResponse] = Json.format[FilmAvailabilityResponse]
}
