package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param reason the reason why the comment was reported
  * @param message an explanatory message to accompany the report
  */
case class ReportCommentRequest(reason: String, message: Option[String])

object ReportCommentRequest {
  implicit val format: Format[ReportCommentRequest] = Json.format[ReportCommentRequest]
}
