package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param input a case-insensitive prefix match, or an empty input to match all tags
  */
case class MemberTagsRequest(input: Option[String])

object MemberTagsRequest {
  implicit val format: Format[MemberTagsRequest] = Json.format[MemberTagsRequest]
}
