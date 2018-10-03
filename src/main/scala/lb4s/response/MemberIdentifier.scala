package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the member
  */
case class MemberIdentifier(id: LBID)

object MemberIdentifier {
  implicit val format: Format[MemberIdentifier] = Json.format[MemberIdentifier]
}
