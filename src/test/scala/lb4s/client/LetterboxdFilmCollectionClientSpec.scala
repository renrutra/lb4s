package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.FilmCollectionRequest

class LetterboxdFilmCollectionClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdFilmCollectionClient" should {
    val filmCollectionId = LBID("ivz")

    "get a film collection" in {
      val request = FilmCollectionRequest()
      val filmCollection = unauthorizedClient.filmCollection(filmCollectionId, request)
      filmCollection.id shouldBe filmCollectionId
      filmCollection.films should not be empty
    }
  }
}
