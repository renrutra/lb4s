package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param items the list of tag items, ordered by frequency of use
  */
case class MemberTagsResponse(items: List[MemberTag])

object MemberTagsResponse {
  implicit val format: Format[MemberTagsResponse] = Json.format[MemberTagsResponse]
}
