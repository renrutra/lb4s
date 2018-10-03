package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param data the response object
  * @param messages a list of messages the API client should show to the user
  */
case class MemberSettingsUpdateResponse(data: MemberAccount, messages: List[MemberSettingsUpdateMessage])

object MemberSettingsUpdateResponse {
  implicit val format: Format[MemberSettingsUpdateResponse] = Json.format[MemberSettingsUpdateResponse]
}
