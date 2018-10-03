package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param filmLikes the number of films the member has liked
  * @param listLikes the number of lists the member has liked
  * @param reviewLikes the number of reviews the member has liked
  * @param watches the number of films the member has watched
  * @param ratings the number of films the member has rated
  * @param reviews the number of films the member has reviewed
  * @param diaryEntries the number of entries the member has in their diary
  * @param diaryEntriesThisYear the number of entries the member has in their diary for the current year
  * @param filmsInDiaryThisYear the number of unique films the member has in their diary for the current year
  * @param watchlist the number of films the member has in their watchlist
  * @param lists the number of lists for the member
  * @param unpublishedLists the number of unpublished lists for the member
  * @param followers the number of members who follow the member
  * @param following the number of members the member is following
  * @param listTags the number of tags the member has used for lists
  * @param filmTags the number of tags the member has used for diary entries and reviews
  */
case class MemberStatisticsCounts(
  filmLikes: Int,
  listLikes: Int,
  reviewLikes: Int,
  watches: Int,
  ratings: Int,
  reviews: Int,
  diaryEntries: Int,
  diaryEntriesThisYear: Int,
  filmsInDiaryThisYear: Int,
  watchlist: Int,
  lists: Int,
  unpublishedLists: Option[Int],
  followers: Int,
  following: Int,
  listTags: Int,
  filmTags: Int
)

object MemberStatisticsCounts {
  implicit val format: Format[MemberStatisticsCounts] = Json.format[MemberStatisticsCounts]
}
