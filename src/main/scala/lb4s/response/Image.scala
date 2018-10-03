package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param sizes the available sizes for the image
  */
case class Image(sizes: List[ImageSize])

object Image {
  implicit val format: Format[Image] = Json.format[Image]
}
