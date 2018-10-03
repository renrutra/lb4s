package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param type denotes which site the link is for
  * @param id the object ID for the linked entity on the destination site
  * @param url the fully qualified URL on the destination site
  */
case class Link(`type`: String, id: String, url: String)

object Link {
  implicit val format: Format[Link] = Json.format[Link]
}
