package lb4s.client

import lb4s.request.NewsRequest
import lb4s.response.NewsResponse

trait LetterboxdNewsClient { this: LetterboxdApiClient =>
  /**
    * A cursored window over recent news from the Letterboxd editors.
    * @param request the request
    * @return the response
    */
  def news(request: NewsRequest): NewsResponse = getRequest[NewsRequest, NewsResponse]("/news", request)
}
