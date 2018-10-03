package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID of the member
  * @param username the member's Letterboxd username
  * @param givenName the given name of the member
  * @param familyName the family name of the member
  * @param displayName the member's given name and family name, or their username if neither is set
  * @param shortName the member's given name, if set, or their username
  * @param pronoun the member's preferred pronoun
  * @param twitterUsername the member's Twitter username, if they have authenticated their account
  * @param bioLbml the member's bio in LBML
  * @param location the member's location
  * @param website the member's website URL
  * @param avatar the member's avatar image
  * @param backdrop the member's backdrop image
  * @param backdropFocalPoint the vertical focal point of the member's backdrop image
  * @param memberStatus the member's account type
  * @param favoriteFilms a summary of the member's favorite films, up to a maximum of four
  * @param pinnedReviews the reviews the member has pinned on their profile page, up to a maximum of two
  * @param links a link to the member's profile page on the Letterboxd website
  * @param privateWatchlist indicates whether the member has elected to hide their watchlist from other members
  * @param bio the member's bio formatted as HTML
  */
case class Member(
  id: LBID,
  username: String,
  givenName: Option[String],
  familyName: Option[String],
  displayName: Option[String],
  shortName: String,
  pronoun: Pronoun,
  twitterUsername: Option[String],
  bioLbml: Option[String],
  location: Option[String],
  website: Option[String],
  avatar: Image,
  backdrop: Option[Image],
  backdropFocalPoint: Option[Double],
  memberStatus: String,
  favoriteFilms: List[FilmSummary],
  pinnedReviews: Option[List[LogEntry]],
  links: List[Link],
  privateWatchlist: Boolean,
  bio: Option[String]
)

object Member {
  implicit val format: Format[Member] = Json.format[Member]
}
