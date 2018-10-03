package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class ReviewUpdateResponse(data: LogEntry, messages: List[LogEntryUpdateMessage])

object ReviewUpdateResponse {
  implicit val format: Format[ReviewUpdateResponse] = Json.format[ReviewUpdateResponse]
}
