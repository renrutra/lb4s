package lb4s.client

import java.util.UUID

import scala.util.Random

class LetterboxdAuthClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdAuthClient" should {
    "check an existing username" in {
      val usernameCheckResponse = unauthorizedClient.checkUsername("crew")
      usernameCheckResponse.result shouldBe "NotAvailable"
    }

    "check an available username" in {
      val username = Random.shuffle(('a' to 'z').toList).take(12).mkString
      val usernameCheckResponse = unauthorizedClient.checkUsername(username)
      usernameCheckResponse.result shouldBe "Available"
    }

    "check an invalid username" in {
      val usernameCheckResponse = unauthorizedClient.checkUsername(UUID.randomUUID.toString)
      usernameCheckResponse.result shouldBe "Invalid"
    }
  }
}
