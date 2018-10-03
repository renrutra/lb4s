package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param id the YouTube ID of the trailer
  * @param url the YouTube URL for the trailer
  */
case class FilmTrailer(id: String, url: String)

object FilmTrailer {
  implicit val format: Format[FilmTrailer] = Json.format[FilmTrailer]
}
