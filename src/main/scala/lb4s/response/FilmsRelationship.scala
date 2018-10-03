package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param counts the number of watches and likes for the films
  */
case class FilmsRelationship(counts: FilmsRelationshipCounts)

object FilmsRelationship {
  implicit val format: Format[FilmsRelationship] = Json.format[FilmsRelationship]
}
