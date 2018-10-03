package lb4s.client

import lb4s.primitive.LBID
import lb4s.request.{FilmRelationshipUpdateRequest, FilmsRequest, MemberFilmRelationshipsRequest, ReportFilmRequest}
import lb4s.response._

trait LetterboxdFilmClient { this: LetterboxdApiClient =>
  /**
    * A cursored window over the list of films.
    * @param request the request
    * @return the response
    */
  def films(request: FilmsRequest): FilmsResponse = getRequest[FilmsRequest, FilmsResponse]("/films", request)

  /**
    * Get a list of services supported.
    * @return the list of film services
    */
  def filmServices: List[Service] = getRequest[FilmServicesResponse]("/films/film-services").items

  /**
    * Get a list of genres supported.
    * @return the list of genres in alphabetical order
    */
  def filmGenres: List[Genre] = getRequest[GenresResponse]("/films/genres").items

  /**
    * Get details about a film.
    * @param id the LBID of the film
    * @return the film
    */
  def film(id: LBID): Film = getRequest[Film](f"/film/$id")

  /**
    * Get availability data about a film.
    * @param id the LBID of the film
    * @return the film availability
    */
  def filmAvailability(id: LBID): List[FilmAvailability] =
    getRequest[FilmAvailabilityResponse](f"/film/$id/availability").items

  /**
    * Get details of the authenticated member's relationship with a film.
    * @param id the LBID of the film
    * @return the film relationship
    */
  def filmRelationship(id: LBID): FilmRelationship = getRequest[FilmRelationship](f"/film/$id/me")

  /**
    * Update the authenticated member's relationship with a film.
    * @param id the LBID of the film
    * @param request the request
    * @return the response
    */
  def updateFilmRelationship(id: LBID, request: FilmRelationshipUpdateRequest): FilmRelationshipUpdateResponse =
    patchRequest[FilmRelationshipUpdateRequest, FilmRelationshipUpdateResponse](f"/film/$id/me", request)

  /**
    * Get details of members' relationships with a film.
    * @param id the LBID of the film
    * @param request the request
    * @return the response
    */
  def memberFilmRelationships(id: LBID, request: MemberFilmRelationshipsRequest): MemberFilmRelationshipsResponse =
    getRequest[MemberFilmRelationshipsRequest, MemberFilmRelationshipsResponse](f"/film/$id/members", request)

  /**
    * Report a film.
    * @param id the LBID of the film
    * @param request the request
    */
  def reportFilm(id: LBID, request: ReportFilmRequest): Unit = postRequest[ReportFilmRequest](f"/film/$id/report", request)

  /**
    * Get statistical data about a film.
    * @param id the LBID of the film
    * @return the film statistics
    */
  def filmStatistics(id: LBID): FilmStatistics = getRequest[FilmStatistics](f"/film/$id/statistics")
}
