package lb4s.response

import lb4s.primitive.{FilmContributionType, LBID}
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

import scala.io.Source

class FilmSpec extends WordSpec with Matchers {
  import FilmContributionType._

  "A Film" should {
    "be parsed from the response" in {
      val apiResponse = Source.fromFile("src/test/resources/film.json").mkString
      val film = Json.parse(apiResponse).as[Film]

      film shouldBe Film(
        LBID("QFk"),
        "Strike",
        Some("Стачка"),
        Some(List("A Greve", "La Grève", "Stachka", "La huelga")),
        Some(1925),
        None,
        Some("The film depicts a strike in 1903 by the workers of a factory in pre-revolutionary Russia, and their subsequent suppression."),
        Some(89),
        Some(Image(List(
          ImageSize(70,105,"http://oblivion.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-70-0-105-crop.jpg?k=35dd8d443c"),
          ImageSize(100,150,"http://skyfall.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-100-0-150-crop.jpg?k=b0823652bc"),
          ImageSize(140,210,"http://zardoz.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-140-0-210-crop.jpg?k=b0823652bc"),
          ImageSize(200,300,"http://oblivion.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-200-0-300-crop.jpg?k=d5dc6328f6"),
          ImageSize(250,375,"http://primer.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-250-0-375-crop.jpg?k=4d4f66e7cb"),
          ImageSize(300,450,"http://zardoz.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-300-0-450-crop.jpg?k=a2ef09d551"),
          ImageSize(400,600,"http://primer.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-400-0-600-crop.jpg?k=f99d35a509"),
          ImageSize(500,750,"http://oblivion.a.ltrbxd.com/resized/film-poster/2/0/2/4/5/20245-strike-0-500-0-750-crop.jpg?k=1685a7cf9f")
        ))),
        None,
        None,
        None,
        List(Genre(LBID("7S"), "Drama")),
        List(
          FilmContributions(Actor, List(
            ContributorSummary(LBID("4W3d"), "Maksim Shtraukh", Some("Police Spy")),
            ContributorSummary(LBID("2RJf"), "Grigori Aleksandrov", Some("Factory Foreman")),
            ContributorSummary(LBID("4W3n"), "Mikhail Gomorov", Some("Worker")),
            ContributorSummary(LBID("t1OL"), "Ivan Klyukvin", Some("Revolutionary")),
            ContributorSummary(LBID("7ksb"), "Aleksandr Antonov", Some("Member of Strike Committee")),
            ContributorSummary(LBID("t1OV"), "I. Ivanov", Some("Chief of Police")),
            ContributorSummary(LBID("t1P5"), "Yudif Glizer", Some("Queen of Thieves")),
            ContributorSummary(LBID("t1Pf"), "Vera Yanukova", Some("")),
            ContributorSummary(LBID("7D6X"), "Vladimir Uralsky", Some("")),
            ContributorSummary(LBID("t1Pp"), "M. Mamin", Some("")),
            ContributorSummary(LBID("t1Pz"), "Boris Yurtsev", Some("King of Thieves")),
            ContributorSummary(LBID("dHRP"), "Daniil Antonovich", Some("Worker (uncredited)"))
          )),
          FilmContributions(Director, List(ContributorSummary(LBID("2j0F"), "Sergei M. Eisenstein", None))),
          FilmContributions(Writer, List(
            ContributorSummary(LBID("2RJf"), "Grigori Aleksandrov", None),
            ContributorSummary(LBID("2j0F"), "Sergei M. Eisenstein", None),
            ContributorSummary(LBID("iV7h"), "Илья Кравчуновский", None),
            ContributorSummary(LBID("iV7r"), "Валериан Плетнёв", None)
          )),
          FilmContributions(Producer, List(ContributorSummary(LBID("qp8D"), "Boris Mikhin", None))),
          FilmContributions(Cinematography, List(
            ContributorSummary(LBID("mMgd"), "Vasili Khvatov", None),
            ContributorSummary(LBID("1Hd"), "Vladimir Popov", None),
            ContributorSummary(LBID("1out"), "Eduard Tisse", None)
          )),
          FilmContributions(ArtDirection, List(ContributorSummary(LBID("iqKd"), "Vasili Rakhals", None))),
          FilmContributions(Studio, List(
            ContributorSummary(LBID("pXwH"), "Proletkult", None),
            ContributorSummary(LBID("q5z5"), "Goskino", None)
          ))
        ),
        None,
        List(
          Link("letterboxd", "QFk", "https://letterboxd.com/film/strike/"),
          Link("tmdb", "44967", "https://www.themoviedb.org/movie/44967"),
          Link("imdb", "tt0015361", "http://www.imdb.com/title/tt0015361/")
        )
      )
    }
  }
}
