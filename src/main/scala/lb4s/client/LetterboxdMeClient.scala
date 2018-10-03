package lb4s.client

import lb4s.request.MemberSettingsUpdateRequest
import lb4s.response.{MemberAccount, MemberSettingsUpdateResponse}

trait LetterboxdMeClient { this: LetterboxdApiClient =>
  /**
    * Get details about the authenticated member.
    * @return the member account
    */
  def me: MemberAccount = getRequest[MemberAccount]("/me")

  /**
    * Update the profile settings for the authenticated member.
    * @param request the request
    * @return the response
    */
  def updateMe(request: MemberSettingsUpdateRequest): MemberSettingsUpdateResponse =
    patchRequest[MemberSettingsUpdateRequest, MemberSettingsUpdateResponse]("/me", request)
}
