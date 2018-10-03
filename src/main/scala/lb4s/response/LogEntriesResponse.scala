package lb4s.response

import lb4s.primitive.Cursor
import play.api.libs.json.{Format, Json}

/**
  * @param next the cursor to the next page of results
  * @param items the list of log entries
  */
case class LogEntriesResponse(next: Option[Cursor], items: List[LogEntry])

object LogEntriesResponse {
  implicit val format: Format[LogEntriesResponse] = Json.format[LogEntriesResponse]
}
