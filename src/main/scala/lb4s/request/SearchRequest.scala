package lb4s.request

import lb4s.primitive.{Cursor, FilmContributionType}
import play.api.libs.json.{Format, Json}

/**
  * @param cursor the pagination cursor
  * @param perPage the number of items to include per page
  * @param input the word, partial word or phrase to search for
  * @param searchMethod the type of search to perform
  * @param include the types of results to search for
  * @param contributionType the type of contributor to search for
  */
case class SearchRequest(
  cursor: Option[Cursor] = None,
  perPage: Int = 20,
  input: String,
  searchMethod: String = "FullText",
  include: List[String] = Nil,
  contributionType: Option[FilmContributionType.Value] = None
)

object SearchRequest {
  implicit val format: Format[SearchRequest] = Json.format[SearchRequest]
}
