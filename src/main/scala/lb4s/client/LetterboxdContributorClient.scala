package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.FilmContributionsRequest
import lb4s.response.{Contributor, FilmContributionsResponse}

trait LetterboxdContributorClient { this: LetterboxdApiClient =>
  /**
    * Get details about a film contributor. Contributors include the film's director(s), cast, crew and studio(s).
    * @param id the LBID of the contributor
    * @return the contributor
    */
  def contributor(id: LBID): Contributor = getRequest[Contributor](f"/contributor/$id")

  /**
    * A cursored window over the list of contributions to films for a contributor.
    * @param id the LBID of the contributor
    * @param request the request
    * @return the response
    */
  def contributions(id: LBID, request: FilmContributionsRequest): FilmContributionsResponse =
    getRequest[FilmContributionsRequest, FilmContributionsResponse](f"/contributor/$id/contributions", request)
}
