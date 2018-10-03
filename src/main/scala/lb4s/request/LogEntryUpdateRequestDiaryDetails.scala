package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param diaryDate the date the film was watched, in ISO 8601 format
  * @param rewatch true if the member has indicated that the member has seen the film prior to this date
  */
case class LogEntryUpdateRequestDiaryDetails(diaryDate: Option[String], rewatch: Boolean)

object LogEntryUpdateRequestDiaryDetails {
  implicit val format: Format[LogEntryUpdateRequestDiaryDetails] = Json.format[LogEntryUpdateRequestDiaryDetails]
}
