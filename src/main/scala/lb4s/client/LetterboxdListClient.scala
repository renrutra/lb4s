package lb4s.client

import lb4s.primitive.LBID
import lb4s.request._
import lb4s.response._

trait LetterboxdListClient { this: LetterboxdApiClient =>
  /**
    * Get details of a list.
    * @param request the LBID of the list
    * @return the response
    */
  def lists(request: ListsRequest): ListsResponse = getRequest[ListsRequest, ListsResponse]("/lists", request)

  /**
    * Create a list.
    * @param request the request
    * @return the response
    */
  def createList(request: ListCreationRequest): ListCreateResponse =
    postRequest[ListCreationRequest, ListCreateResponse]("/lists", request)

  /**
    * Get details of a list.
    * @param id the LBID of the list
    * @return the list
    */
  def list(id: LBID): FilmList = getRequest[FilmList](f"/list/$id")

  /**
    * Update a list.
    * @param id the LBID of the list
    * @param request the request
    * @return the response
    */
  def updateList(id: LBID, request: ListUpdateRequest): ListUpdateResponse =
    patchRequest[ListUpdateRequest, ListUpdateResponse](f"/list/$id", request)

  /**
    * Delete a list.
    * @param id the LBID of the list
    */
  def deleteList(id: LBID): Unit = deleteRequest(f"/list/$id")

  /**
    * A cursored window over the comments for a list.
    * @param id the LBID of the list
    * @param request the request
    * @return the response
    */
  def listComments(id: LBID, request: CommentsRequest): ListCommentsResponse =
    getRequest[CommentsRequest, ListCommentsResponse](f"/list/$id/comments", request)

  /**
    * Create a comment on a list.
    * @param id the LBID of the list
    * @param request the request
    * @return the response
    */
  def createListComment(id: LBID, request: CommentCreationRequest): ListComment =
    postRequest[CommentCreationRequest, ListComment](f"/list/$id/comments", request)

  /**
    * Get entries for a list.
    * @param id the LBID of the list
    * @param request the request
    * @return the response
    */
  def listEntries(id: LBID, request: ListEntriesRequest): ListEntriesResponse =
    getRequest[ListEntriesRequest, ListEntriesResponse](f"/list/$id/entries", request)

  /**
    * Get details of the authenticated member's relationship with a list.
    * @param id the LBID of the list
    * @return the list relationship
    */
  def listRelationship(id: LBID): ListRelationship = getRequest[ListRelationship](f"/list/$id/me")

  /**
    * Update the authenticated member's relationship with a list.
    * @param id the LBID of the list
    * @param request the request
    * @return the response
    */
  def updateListRelationship(id: LBID, request: ListRelationshipUpdateRequest): ListRelationshipUpdateResponse =
    patchRequest[ListRelationshipUpdateRequest, ListRelationshipUpdateResponse](f"/list/$id/me", request)

  /**
    * Report a list.
    * @param id the LBID of the list
    * @param request the request
    */
  def reportList(id: LBID, request: ReportListRequest): Unit =
    postRequest[ReportListRequest](f"/list/$id/report", request)

  /**
    * Get statistical data about a list.
    * @param id the LBID of the list
    * @return the list statistics
    */
  def listStatistics(id: LBID): ListStatistics = getRequest[ListStatistics](f"/list/$id/statistics")
}
