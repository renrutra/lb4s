package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param reason the reason why the list was reported
  * @param message an explanatory message to accompany the report
  */
case class ReportListRequest(reason: String, message: Option[String])

object ReportListRequest {
  implicit val format: Format[ReportListRequest] = Json.format[ReportListRequest]
}
