package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the service
  * @param name the name of the service
  */
case class Service(id: LBID, name: String)

object Service {
  implicit val format: Format[Service] = Json.format[Service]
}
