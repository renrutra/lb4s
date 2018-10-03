package lb4s.client

import lb4s.request.NewsRequest

class LetterboxdNewsClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdNewsClient" should {
    "get news items" in {
      val request = NewsRequest(perPage = 5)
      val newsResponse = unauthorizedClient.news(request)
      newsResponse.next shouldBe defined
      newsResponse.items should have length request.perPage
    }
  }
}
