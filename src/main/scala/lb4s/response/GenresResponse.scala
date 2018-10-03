package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param items the list of genres
  */
case class GenresResponse(items: List[Genre])

object GenresResponse {
  implicit val format: Format[GenresResponse] = Json.format[GenresResponse]
}
