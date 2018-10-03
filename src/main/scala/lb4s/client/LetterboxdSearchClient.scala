package lb4s.client

import lb4s.request.SearchRequest
import lb4s.response.SearchResponse

trait LetterboxdSearchClient { this: LetterboxdApiClient =>
  /**
    * A cursored window over a list of search items.
    * @param request the request
    * @return the response
    */
  def search(request: SearchRequest): SearchResponse =
    getRequest[SearchRequest, SearchResponse]("/search", request)
}
