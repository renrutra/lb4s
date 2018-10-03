package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param emailAddress the member's email address
  * @param emailAddressValidated true if the member has validated their emailAddress via an emailed link
  * @param privateAccount indicates whether the member has elected for their content to appear in the API
  * @param includeInPeopleSection indicates whether the member has elected to appear in the People section
  * @param emailWhenFollowed indicates whether the member has elected to receive email notifications
  *                          when they receive a new follower
  * @param emailComments indicates whether the member has elected to receive email notifications
  *                      when new comments are posted in threads they are subscribed to
  * @param emailNews indicates whether the member has elected to receive regular email news from Letterboxd
  * @param emailRushes indicates whether the member has elected to receive weekly Letterboxd rushes
  * @param canComment indicates whether the member has commenting privileges
  * @param suspended indicates whether the member is suspended from commenting due to a breach of the Community Policy
  * @param canCloneLists indicates whether the member is able to clone other members' lists
  * @param canFilterActivity indicates whether the member is able to filter activity by type
  * @param authorizedSharingServicesForLists the services the member has authorized Letterboxd to share lists to
  * @param authorizedSharingServicesForReviews the services the member has authorized Letterboxd to share reviews to
  * @param membershipDaysRemaining the number of days the member has left in their subscription
  * @param member standard member details
  */
case class MemberAccount(
  emailAddress: String,
  emailAddressValidated: Boolean,
  privateAccount: Boolean,
  includeInPeopleSection: Boolean,
  emailWhenFollowed: Boolean,
  emailComments: Boolean,
  emailNews: Boolean,
  emailRushes: Boolean,
  canComment: Boolean,
  suspended: Boolean,
  canCloneLists: Boolean,
  canFilterActivity: Boolean,
  authorizedSharingServicesForLists: List[String],
  authorizedSharingServicesForReviews: List[String],
  membershipDaysRemaining: Option[Int],
  member: Member
)

object MemberAccount {
  implicit val format: Format[MemberAccount] = Json.format[MemberAccount]
}
