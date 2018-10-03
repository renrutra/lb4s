package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param title the title of the news item
  * @param image the image
  * @param url the URL of the news item
  * @param shortDescription a short description of the news item in LBML
  * @param longDescription a long description of the news item in LBML
  */
case class NewsItem(
  title: String,
  image: Image,
  url: String,
  shortDescription: String,
  longDescription: String
)

object NewsItem {
  implicit val format: Format[NewsItem] = Json.format[NewsItem]
}
