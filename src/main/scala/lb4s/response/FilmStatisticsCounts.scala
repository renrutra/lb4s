package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param watches the number of members who have watched the film
  * @param likes the number of members who have liked the film
  * @param ratings the number of members who have rated the film
  * @param fans the number of members who have the film as one of their four favorites
  * @param lists the number of lists in which the film appears
  * @param reviews the number of reviews for the film
  */
case class FilmStatisticsCounts(
  watches: Int,
  likes: Int,
  ratings: Int,
  fans: Int,
  lists: Int,
  reviews: Int
)

object FilmStatisticsCounts {
  implicit val format: Format[FilmStatisticsCounts] = Json.format[FilmStatisticsCounts]
}
