package lb4s.client

class AuthorizedLetterboxdClient(
  override val apiKey: String,
  override val apiSecret: String,
  token: AccessToken,
  private val authorizedAt: Long
) extends LetterboxdApiClient {
  override def accessToken: Option[AccessToken] = Some(token)

  def refresh(): AuthorizedLetterboxdClient = {
    val authorizedAt = System.currentTimeMillis
    val authorizationToken = authToken("grant_type" -> "refresh_token", "refresh_token" -> token.refreshToken)

    new AuthorizedLetterboxdClient(apiKey, apiSecret, authorizationToken, authorizedAt)
  }

  def needsRefresh: Boolean = System.currentTimeMillis >= authorizedAt + token.expiresIn.toMillis
}
