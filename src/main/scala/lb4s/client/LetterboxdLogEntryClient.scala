package lb4s.client

import lb4s.primitive.LBID
import lb4s.request._
import lb4s.response._

trait LetterboxdLogEntryClient { this: LetterboxdApiClient =>
  /**
    * A cursored window over the log entries for a film or member.
    * A log entry is either a diary entry (must have a date) or a review (must have review text).
    * @param request the request
    * @return the response
    */
  def logEntries(request: LogEntriesRequest): LogEntriesResponse =
    getRequest[LogEntriesRequest, LogEntriesResponse]("/log-entries", request)

  /**
    * Create a log entry. A log entry is either a diary entry (must have a date) or a review (must have review text).
    * @param request the request
    * @return the response
    */
  def createLogEntry(request: LogEntryCreationRequest): LogEntry =
    postRequest[LogEntryCreationRequest, LogEntry]("/log-entries", request)

  /**
    * Get details about a log entry.
    * @param id the LBID of the log entry
    * @return the log entry
    */
  def logEntry(id: LBID): LogEntry = getRequest[LogEntry](f"/log-entry/$id")

  /**
    * Update a log entry.
    * @param id the LBID of the log entry
    * @param request the request
    * @return the response
    */
  def updateLogEntry(id: LBID, request: LogEntryUpdateRequest): ReviewUpdateResponse =
    patchRequest[LogEntryUpdateRequest, ReviewUpdateResponse](f"/log-entry/$id", request)

  /**
    * Delete a log entry.
    * @param id the LBID of the log entry
    */
  def deleteLogEntry(id: LBID): Unit = deleteRequest(f"/log-entry/$id")

  /**
    * A cursored window over the comments for a log entry's review.
    * @param id the LBID of the log entry
    * @param request the request
    * @return the response
    */
  def logEntryComments(id: LBID, request: CommentsRequest): ReviewCommentsResponse =
    getRequest[CommentsRequest, ReviewCommentsResponse](f"/log-entry/$id/comments", request)

  /**
    * Create a comment on a review.
    * @param id the LBID of the log entry
    * @param request the request
    * @return the review comment
    */
  def createLogEntryComment(id: LBID, request: CommentCreationRequest): ReviewComment =
    postRequest[CommentCreationRequest, ReviewComment](f"/log-entry/$id/comments", request)

  /**
    * Get details of the authenticated member's relationship with a log entry's review.
    * @param id the LBID of the log entry
    * @return the review relationship
    */
  def logEntryRelationship(id: LBID): ReviewRelationship = getRequest[ReviewRelationship](f"/log-entry/$id/me")

  /**
    * Update the authenticated member's relationship with a log entry's review.
    * @param id the LBID of the log entry
    * @param request the request
    * @return the response
    */
  def updateLogEntryRelationship(id: LBID, request: ReviewRelationshipUpdateRequest): ReviewRelationshipUpdateResponse =
    patchRequest[ReviewRelationshipUpdateRequest, ReviewRelationshipUpdateResponse](f"/log-entry/$id/me", request)

  /**
    * Report a log entry's review.
    * @param id the LBID of the log entry
    * @param request the request
    */
  def reportLogEntry(id: LBID, request: ReportReviewRequest): Unit =
    postRequest[ReportReviewRequest](f"/log-entry/$id/report", request)

  /**
    * Get statistical data about a log entry's review.
    * @param id the LBID of the log entry
    * @return the review statistics
    */
  def logEntryStatistics(id: LBID): ReviewStatistics = getRequest[ReviewStatistics](f"/log-entry/$id/statistics")
}
