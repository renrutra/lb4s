package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.{FilmsRequest, MemberFilmRelationshipsRequest}

class LetterboxdFilmClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdFilmClient" should {
    val filmId = LBID("2hNM")

    "get films" in {
      val request = FilmsRequest(perPage = 5)
      val filmsResponse = unauthorizedClient.films(request)
      filmsResponse.next shouldBe defined
      filmsResponse.items should have length request.perPage
    }

    "get film services" in {
      val filmServices = unauthorizedClient.filmServices
      filmServices should not be empty
    }

    "get film genres" in {
      val filmGenres = unauthorizedClient.filmGenres
      filmGenres should not be empty
    }

    "get a film" in {
      val film = unauthorizedClient.film(filmId)
      film.links should not be empty
    }

    "get the member's film relationship" in {
      val filmRelationship = authorizedClient.filmRelationship(filmId)
      filmRelationship should not be null
    }

    "get the members' film relationships" in {
      val request = MemberFilmRelationshipsRequest(perPage = 5)
      val filmRelationships = unauthorizedClient.memberFilmRelationships(filmId, request)
      filmRelationships.items should have length request.perPage
    }

    "get a film's statistics" in {
      val filmStatistics = unauthorizedClient.filmStatistics(filmId)
      filmStatistics.film.id shouldBe filmId
      filmStatistics.rating shouldBe defined
      filmStatistics.ratingsHistogram should not be empty
    }
  }
}
