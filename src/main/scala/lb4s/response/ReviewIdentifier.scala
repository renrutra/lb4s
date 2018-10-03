package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the log entry
  */
case class ReviewIdentifier(id: LBID)

object ReviewIdentifier {
  implicit val format: Format[ReviewIdentifier] = Json.format[ReviewIdentifier]
}
