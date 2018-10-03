package lb4s.client

class UnauthorizedLetterboxdClient(
  override val apiKey: String,
  override val apiSecret: String
) extends LetterboxdApiClient {
  override def accessToken: Option[AccessToken] = None

  def authorize(username: String, password: String): AuthorizedLetterboxdClient = {
    val authorizedAt = System.currentTimeMillis

    val authorizationToken = authToken("grant_type" -> "password", "username" -> username, "password" -> password)
    new AuthorizedLetterboxdClient(apiKey, apiSecret, authorizationToken, authorizedAt)
  }
}
