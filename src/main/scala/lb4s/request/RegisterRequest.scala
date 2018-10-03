package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param username the username for the new account
  * @param password the password for the new account
  * @param emailAddress the email address for the new account
  * @param acceptTermsOfUse true if the person creating the account has agreed to being at least 13 years of age,
  *                         and to accepting Letterboxd's Terms of Use
  */
case class RegisterRequest(
  username: String,
  password: String,
  emailAddress: String,
  acceptTermsOfUse: Boolean
)

object RegisterRequest {
  implicit val format: Format[RegisterRequest] = Json.format[RegisterRequest]
}
