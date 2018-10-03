package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.FilmContributionsRequest

class LetterboxdContributorClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdContributorClient" should {
    val contributorId = LBID("3hV")

    "get a contributor" in {
      val contributor = unauthorizedClient.contributor(contributorId)
      contributor.id shouldBe contributorId
      contributor.links should not be empty
    }

    "get contributions" in {
      val request = FilmContributionsRequest(perPage = 5)
      val contributions = unauthorizedClient.contributions(contributorId, request)
      contributions.next shouldBe defined
      contributions.items should have length request.perPage
    }
  }
}
