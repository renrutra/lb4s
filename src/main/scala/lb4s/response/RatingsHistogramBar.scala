package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param rating the rating increment between 0.5 and 5.0
  * @param normalizedWeight the normalized height of this rating increment's entry in a unit-height histogram
  * @param count the number of ratings made at this increment
  */
case class RatingsHistogramBar(rating: Double, normalizedWeight: Double, count: Int)

object RatingsHistogramBar {
  implicit val format: Format[RatingsHistogramBar] = Json.format[RatingsHistogramBar]
}
