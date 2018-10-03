package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param reason the reason why the review was reported
  * @param message an explanatory message to accompany the report
  */
case class ReportReviewRequest(reason: String, message: Option[String])

object ReportReviewRequest {
  implicit val format: Format[ReportReviewRequest] = Json.format[ReportReviewRequest]
}
