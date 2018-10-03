package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class ListCreateResponse(data: FilmList, messages: List[ListCreateMessage])

object ListCreateResponse {
  implicit val format: Format[ListCreateResponse] = Json.format[ListCreateResponse]
}
