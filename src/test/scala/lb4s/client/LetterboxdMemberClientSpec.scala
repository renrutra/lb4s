package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.{ActivityRequest, MemberTagsRequest, MembersRequest, WatchlistRequest}

class LetterboxdMemberClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdMemberClient" should {
    val memberId = LBID("1lhl")

    "get members" in {
      val request = MembersRequest(perPage = 5)
      val membersResponse = unauthorizedClient.members(request)
      membersResponse.next shouldBe defined
      membersResponse.items should have length request.perPage
    }

    "get member pronouns" in {
      val pronouns = unauthorizedClient.memberPronouns
      pronouns should not be empty
    }

    "get a member" in {
      val member = unauthorizedClient.member(memberId)
      member.id shouldBe memberId
      member.links should not be empty
    }

    "get a member's activity" in {
      val request = ActivityRequest(perPage = 5)
      val activityResponse = unauthorizedClient.memberActivity(memberId, request)
      activityResponse.next shouldBe defined
      activityResponse.items should have length request.perPage
    }

    "get the member's relationship with a member" in {
      val memberRelationship = authorizedClient.memberRelationship(memberId)
      memberRelationship should not be null
    }

    "get a member's statistics" in {
      val memberStatistics = unauthorizedClient.memberStatistics(memberId)
      memberStatistics.member.id shouldBe memberId
      memberStatistics.ratingsHistogram should not be empty
    }
  }
}
