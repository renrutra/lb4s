package lb4s.request

import play.api.libs.json.{Format, Json}

/**
  * @param following true if the authenticated member wishes to follow the member identified by ID,
  *                  or false if they wish to unfollow
  * @param blocking true if the authenticated member wishes to block the member identified by ID,
  *                 or false if they wish to unblock
  */
case class MemberRelationshipUpdateRequest(following: Option[Boolean], blocking: Option[Boolean])

object MemberRelationshipUpdateRequest {
  implicit val format: Format[MemberRelationshipUpdateRequest] = Json.format[MemberRelationshipUpdateRequest]
}
