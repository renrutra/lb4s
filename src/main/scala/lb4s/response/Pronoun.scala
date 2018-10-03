package lb4s.response

import lb4s.primitive.LBID
import play.api.libs.json.{Format, Json}

/**
  * @param id the LBID for this pronoun
  * @param label a label to describe this pronoun
  * @param subjectPronoun the pronoun to use when the member is the subject
  * @param objectPronoun the pronoun to use when the member is the object
  * @param possessiveAdjective the adjective to use when describing a specified thing or things
  *                            belonging to or associated with a member previously mentioned
  * @param possessivePronoun the pronoun to use when referring to a specified thing or things
  *                          belonging to or associated with a member previously mentioned
  * @param reflexive the pronoun to use to refer back to the member
  */
case class Pronoun(
  id: LBID,
  label: String,
  subjectPronoun: String,
  objectPronoun: String,
  possessiveAdjective: String,
  possessivePronoun: String,
  reflexive: String
)

object Pronoun {
  implicit val format: Format[Pronoun] = Json.format[Pronoun]
}
