package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param film the film for which statistics were requested
  * @param counts the number of watches, ratings, likes, etc. for the film
  * @param rating the weighted average rating of the film, if the film has received sufficient ratings
  * @param ratingsHistogram a summary of the number of ratings at each increment between 0.5 and 5.0
  */
case class FilmStatistics(
  film: FilmIdentifier,
  counts: FilmStatisticsCounts,
  rating: Option[Double],
  ratingsHistogram: List[RatingsHistogramBar]
)

object FilmStatistics {
  implicit val format: Format[FilmStatistics] = Json.format[FilmStatistics]
}
