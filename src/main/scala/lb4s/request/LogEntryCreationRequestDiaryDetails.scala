package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param diaryDate the date the film was watched, in ISO 8601 format
  * @param rewatch true if the member has indicated that the member has seen the film prior to this date
  */
case class LogEntryCreationRequestDiaryDetails(diaryDate: Option[String], rewatch: Boolean)

object LogEntryCreationRequestDiaryDetails {
  implicit val format: Format[LogEntryCreationRequestDiaryDetails] = Json.format[LogEntryCreationRequestDiaryDetails]
}
