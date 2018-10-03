package lb4s.primitive

import play.api.libs.json.Format

object CommentThreadState extends Enumeration {
  import play.api.libs.functional.syntax._

  val CanComment, Banned, Blocked, NotCommentable = Value

  implicit val format: Format[Value] = Format.of[String].inmap(withName, _.toString)
}
