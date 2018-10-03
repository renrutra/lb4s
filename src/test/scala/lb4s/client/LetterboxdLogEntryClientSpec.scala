package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.{CommentsRequest, LogEntriesRequest}

class LetterboxdLogEntryClientSpec extends LetterboxdApiClientSpec {
  "A LetterboxdLogEntryClient" should {
    val logEntryId = LBID("8dYfN")

    "get log entries" in {
      val request = LogEntriesRequest(perPage = 5)
      val logEntriesResponse = unauthorizedClient.logEntries(request)
      logEntriesResponse.next shouldBe defined
      logEntriesResponse.items should have length request.perPage
    }

    "get a log entry" in {
      val logEntry = unauthorizedClient.logEntry(logEntryId)
      logEntry.id shouldBe logEntryId
      logEntry.links should not be empty
    }

    "get a log entry's comments" in {
      val request = CommentsRequest(perPage = 5)
      val reviewCommentsResponse = unauthorizedClient.logEntryComments(logEntryId, request)
      reviewCommentsResponse.next shouldBe defined
      reviewCommentsResponse.items should have length request.perPage
    }

    "get the member's relationship with a log entry" in {
      val reviewRelationship = authorizedClient.logEntryRelationship(logEntryId)
      reviewRelationship should not be null
    }

    "get a log entry's statistics" in {
      val reviewStatistics = unauthorizedClient.logEntryStatistics(logEntryId)
      reviewStatistics.logEntry.id shouldBe logEntryId
    }
  }
}
