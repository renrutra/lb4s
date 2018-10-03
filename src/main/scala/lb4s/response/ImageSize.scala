package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param width the image width in pixels
  * @param height the image height in pixels
  * @param url the URL to the image file
  */
case class ImageSize(width: Int, height: Int, url: String)

object ImageSize {
  implicit val format: Format[ImageSize] = Json.format[ImageSize]
}
