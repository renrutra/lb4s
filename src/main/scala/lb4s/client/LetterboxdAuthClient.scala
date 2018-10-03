package lb4s.client

import lb4s.response.UsernameCheckResponse
import org.apache.http.HttpHeaders

trait LetterboxdAuthClient { this: LetterboxdApiClient =>
  import HttpHeaders._

  protected def authToken(params: (String, String)*): AccessToken = {
    val body = params.map({ case (key, value) => f"$key=$value" }).mkString("&")
    val request = buildRequest("POST", "/auth/token", body).header(CONTENT_TYPE, "application/x-www-form-urlencoded")

    parseResponse[AccessToken](makeRequest(request))
  }

  /**
    * Check if a username is available to register.
    * @param username the username
    * @return the response
    */
  def checkUsername(username: String): UsernameCheckResponse =
    getRequest[UsernameCheckResponse]("/auth/username-check", List("username" -> username))
}
