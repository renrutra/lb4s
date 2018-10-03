package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the list
  */
case class ListIdentifier(id: LBID)

object ListIdentifier {
  implicit val format: Format[ListIdentifier] = Json.format[ListIdentifier]
}
