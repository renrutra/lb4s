package lb4s.client

import lb4s.request.SearchRequest

class LetterboxdSearchClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdSearchClient" should {
    "get search results" in {
      val request = SearchRequest(input = "Bill", perPage = 10)
      val searchResponse = unauthorizedClient.search(request)
      searchResponse.next shouldBe defined
      searchResponse.items should have length request.perPage
    }
  }
}
