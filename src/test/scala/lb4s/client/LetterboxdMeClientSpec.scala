package lb4s.client

class LetterboxdMeClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdMeClient" should {
    "get the authenticated member" in {
      val memberAccount = authorizedClient.me
      memberAccount should not be null
    }
  }
}
