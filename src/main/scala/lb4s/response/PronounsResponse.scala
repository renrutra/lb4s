package lb4s.response

import play.api.libs.json.{Format, Json}

/**
  * @param items the list of pronouns
  */
case class PronounsResponse(items: List[Pronoun])

object PronounsResponse {
  implicit val format: Format[PronounsResponse] = Json.format[PronounsResponse]
}
