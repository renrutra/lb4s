package lb4s.client

import lb4s.primitive.LBID
import lb4s.request._
import lb4s.response._

trait LetterboxdMemberClient { this: LetterboxdApiClient =>
  /**
    * A cursored window over the list of members.
    * @param request the request
    * @return the response
    */
  def members(request: MembersRequest): MembersResponse =
    getRequest[MembersRequest, MembersResponse]("/members", request)

  /**
    * Get a list of pronouns supported.
    * @return the list of pronouns
    */
  def memberPronouns: List[Pronoun] = getRequest[PronounsResponse]("/members/pronouns").items

  /**
    * Create a new account.
    * @param request the request
    * @return the member
    */
  def register(request: RegisterRequest): Member = postRequest[RegisterRequest, Member]("/members/register", request)

  /**
    * Get details about a member.
    * @param id the LBID of the member
    * @return the member
    */
  def member(id: LBID): Member = getRequest[Member](f"/member/$id")

  /**
    * A cursored window over the activity for a member.
    * @param id the LBID of the member
    * @param request the request
    * @return the response
    */
  def memberActivity(id: LBID, request: ActivityRequest): ActivityResponse =
    getRequest[ActivityRequest, ActivityResponse](f"/member/$id/activity", request)

  /**
    * Get the list of a member's tags, or those that match an optional search prefix.
    * @param id the LBID of the member
    * @param request the request
    * @return the list of tags in order of relevance
    */
  def memberListTags(id: LBID, request: MemberTagsRequest): List[MemberTag] =
    getRequest[MemberTagsRequest, MemberTagsResponse](f"/member/$id/list-tags-2", request).items

  /**
    * Get details of the authenticated member's relationship with another member.
    * @param id the LBID of the member
    * @return the member relationship
    */
  def memberRelationship(id: LBID): MemberRelationship = getRequest[MemberRelationship](f"/member/$id/me")

  def updateMemberRelationship(id: LBID, request: MemberRelationshipUpdateRequest): MemberRelationshipUpdateResponse =
    patchRequest[MemberRelationshipUpdateRequest, MemberRelationshipUpdateResponse](f"/member/$id/me", request)

  /**
    * Report a member.
    * @param id the LBID of the member
    * @param request the request
    */
  def reportMember(id: LBID, request: ReportMemberRequest): Unit =
    postRequest[ReportMemberRequest](f"/member/$id/report", request)

  /**
    * Get statistical data about a member by ID.
    * @param id the LBID of the member
    * @return the member statistics
    */
  def memberStatistics(id: LBID): MemberStatistics = getRequest[MemberStatistics](f"/member/$id/statistics")

  /**
    * Get details of a member's public watchlist.
    * @param id the LBID of the member
    * @param request the request
    * @return the response
    */
  def memberWatchlist(id: LBID, request: WatchlistRequest): FilmsResponse =
    getRequest[WatchlistRequest, FilmsResponse](f"/member/$id/watchlist", request)
}
