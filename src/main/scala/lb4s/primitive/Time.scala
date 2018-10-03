package lb4s.primitive

import java.util.Date

import com.fasterxml.jackson.databind.util.ISO8601DateFormat
import play.api.libs.json.Format

case class Time(date: Date) extends Ordered[Time] {
  import Time._

  def iso8601: String = DATE_FORMAT.format(date)

  override def compare(that: Time): Int = this.date.compareTo(that.date)
}

object Time {
  import play.api.libs.functional.syntax._

  private val DATE_FORMAT = new ISO8601DateFormat

  implicit val format: Format[Time] = Format.of[String].inmap(Time(_), _.iso8601)

  def apply(iso8601: String): Time = Time(DATE_FORMAT.parse(iso8601))
}
