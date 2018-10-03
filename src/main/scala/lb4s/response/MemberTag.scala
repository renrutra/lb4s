package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param code the tag code
  * @param displayTag the tag text as entered by the tagger
  * @param counts counts of the member's uses of this tag
  */
case class MemberTag(code: String, displayTag: String, counts: MemberTagCounts)

object MemberTag {
  implicit val format: Format[MemberTag] = Json.format[MemberTag]
}
