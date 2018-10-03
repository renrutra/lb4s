package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.{CommentUpdateRequest, ReportCommentRequest}
import lb4s.response.CommentUpdateResponse

trait LetterboxdCommentClient { this: LetterboxdApiClient =>
  /**
    * Update the message portion of a comment.
    * @param id the LBID of the comment
    * @param request the request
    * @return the response
    */
  def updateComment(id: LBID, request: CommentUpdateRequest): CommentUpdateResponse =
    patchRequest[CommentUpdateRequest, CommentUpdateResponse](f"/contributor/$id", request)

  /**
    * Delete a comment.
    * @param id the LBID of the comment
    */
  def deleteComment(id: LBID): Unit = deleteRequest(f"/comment/$id")

  /**
    * Report a comment.
    * @param id the LBID of the comment
    * @param request the request
    */
  def reportComment(id: LBID, request: ReportCommentRequest): Unit =
    postRequest[ReportCommentRequest](f"/comment/$id/report", request)
}
