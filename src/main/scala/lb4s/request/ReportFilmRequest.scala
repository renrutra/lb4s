package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param reason the reason why the film was reported
  * @param message an explanatory message to accompany the report
  */
case class ReportFilmRequest(reason: String, message: Option[String])

object ReportFilmRequest {
  implicit val format: Format[ReportFilmRequest] = Json.format[ReportFilmRequest]
}
