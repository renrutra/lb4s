package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param reason the reason why the member was reported
  * @param message an explanatory message to accompany the report
  */
case class ReportMemberRequest(reason: String, message: Option[String])

object ReportMemberRequest {
  implicit val format: Format[ReportMemberRequest] = Json.format[ReportMemberRequest]
}
