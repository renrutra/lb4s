package lb4s.request

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param emailAddress the member's email address
  * @param currentPassword the member's current password, required when updating the password
  * @param password the member's new password
  * @param givenName the given name of the member
  * @param familyName the family name of the member
  * @param pronoun the LBID of the member's preferred pronoun
  * @param location the member's location
  * @param website the member's website URL
  * @param bio the member's bio in LBML
  * @param favoriteFilms the LBIDs of the member's favorite films, in order, up to a maximum of four
  * @param privateAccount true to prevent the member's content from appearing in API requests
  * @param includeInPeopleSection false to remove the account from the People section of the Letterboxd website
  * @param emailWhenFollowed true if the member wishes to receive email notifications when they receive a new follower
  * @param emailComments true if the member wishes to receive email notifications
  *                      when new comments are posted in threads they are subscribed to
  * @param emailNews true if the member wishes to receive regular email news from Letterboxd
  * @param emailRushes true if the member wishes to receive a weekly email digest of new and popular content
  */
case class MemberSettingsUpdateRequest(
  emailAddress: Option[String] = None,
  currentPassword: Option[String] = None,
  password: Option[String] = None,
  givenName: Option[String] = None,
  familyName: Option[String] = None,
  pronoun: Option[LBID] = None,
  location: Option[String] = None,
  website: Option[String] = None,
  bio: Option[String] = None,
  favoriteFilms: Option[List[LBID]] = None,
  privateAccount: Option[Boolean] = None,
  includeInPeopleSection: Option[Boolean] = None,
  emailWhenFollowed: Option[Boolean] = None,
  emailComments: Option[Boolean] = None,
  emailNews: Option[Boolean] = None,
  emailRushes: Option[Boolean] = None
)

object MemberSettingsUpdateRequest {
  implicit val format: Format[MemberSettingsUpdateRequest] = Json.format[MemberSettingsUpdateRequest]
}
