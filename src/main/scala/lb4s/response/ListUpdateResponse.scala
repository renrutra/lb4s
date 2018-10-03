package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class ListUpdateResponse(data: FilmList, messages: List[ListUpdateMessage])

object ListUpdateResponse {
  implicit val format: Format[ListUpdateResponse] = Json.format[ListUpdateResponse]
}
