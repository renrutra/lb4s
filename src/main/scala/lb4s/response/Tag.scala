package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param code the tag code
  * @param displayTag the tag text as entered by the tagger
  */
case class Tag(code: String, displayTag: String)

object Tag {
  implicit val format: Format[Tag] = Json.format[Tag]
}
