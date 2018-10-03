package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.FilmCollectionRequest
import lb4s.response.FilmCollection

trait LetterboxdFilmCollectionClient { this: LetterboxdApiClient =>
  /**
    * A cursored window over the list of films.
    * @param request the request
    * @return the response
    */
  def filmCollection(id: LBID, request: FilmCollectionRequest): FilmCollection =
    getRequest[FilmCollectionRequest, FilmCollection](f"/film-collection/$id", request)
}
