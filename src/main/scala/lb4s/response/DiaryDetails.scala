package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param diaryDate the date the film was watched, in ISO 8601 format
  * @param rewatch true if the member has seen the film prior to this date
  */
case class DiaryDetails(diaryDate: Option[String], rewatch: Boolean)

object DiaryDetails {
  implicit val format: Format[DiaryDetails] = Json.format[DiaryDetails]
}
