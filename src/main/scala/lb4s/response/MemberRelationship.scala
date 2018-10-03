package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param following true if the authenticated member follows the member identified by ID
  * @param followedBy true if the member identified by ID follows the authenticated member
  * @param blocking true if the authenticated member has blocked the member identified by ID
  * @param blockedBy true if the member identified by ID has blocked the authenticated member
  */
case class MemberRelationship(following: Boolean, followedBy: Boolean, blocking: Boolean, blockedBy: Boolean)

object MemberRelationship {
  implicit val format: Format[MemberRelationship] = Json.format[MemberRelationship]
}
