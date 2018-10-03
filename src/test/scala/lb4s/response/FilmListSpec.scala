package lb4s.response

import lb4s.primitive.{LBID, Time}
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

import scala.io.Source

class FilmListSpec extends WordSpec with Matchers {
  "A FilmList" should {
    "be parsed from the response" in {
      val apiResponse = Source.fromFile("src/test/resources/film_list.json").mkString
      val filmList = Json.parse(apiResponse).as[FilmList]

      filmList shouldBe FilmList(
        LBID("lul1g"),
        "Sausage dog",
        2,
        published = true,
        ranked = false,
        hasEntriesWithNotes = false,
        None,
        Some(Nil),
        None,
        None,
        Time("2018-01-21T13:54:07Z"),
        Some(Time("2018-01-21T13:54:07Z")),
        MemberSummary(
          LBID("4Ezf"),
          "kurzonc",
          None,
          None,
          Some("kurzonc"),
          "kurzonc",
          Pronoun(LBID("5t"), "She / her", "she", "her", "her", "hers", "herself"),
          Image(List(
            ImageSize(144, 144, "https://a.ltrbxd.com/resized/avatar/twitter/img_144.jpg"),
            ImageSize(300, 300, "https://a.ltrbxd.com/resized/avatar/twitter/img_300.jpg")
          )),
          "Member"
        ),
        None,
        List(
          ListEntrySummary(
            None,
            FilmSummary(
              LBID("aD3M"),
              "Wiener-Dog",
              None,
              None,
              Some(2016),
              Some(List(ContributorSummary(LBID("2XBh"), "Todd Solondz", None))),
              Some(Image(List(
                ImageSize(70,105,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-70-0-105-crop.jpg?k=908f7fe5df"),
                ImageSize(100,150,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-100-0-150-crop.jpg?k=2acb2388bd"),
                ImageSize(140,210,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-140-0-210-crop.jpg?k=d9b34e8c0a"),
                ImageSize(200,300,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-200-0-300-crop.jpg?k=e780bf961e"),
                ImageSize(250,375,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-250-0-375-crop.jpg?k=cd9e03b925"),
                ImageSize(300,450,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-300-0-450-crop.jpg?k=a6b1c6159f"),
                ImageSize(400,600,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-400-0-600-crop.jpg?k=c6c9268235"),
                ImageSize(500,750,"https://a.ltrbxd.com/resized/sm/upload/id/hh/2l/a3/p9qJTbNoDsO1GC63sDYd9yuTGgC-0-500-0-750-crop.jpg?k=a9f6479409")
              ))),
              None,
              List(
                Link("letterboxd", "aD3M", "https://letterboxd.com/film/wiener-dog/"),
                Link("tmdb", "326094", "https://www.themoviedb.org/movie/326094"),
                Link("imdb", "tt4144190", "http://www.imdb.com/title/tt4144190/")
              ),
              Some(List(
                MemberFilmRelationship(
                  MemberSummary(
                    LBID("4Ezf"),
                    "kurzonc",
                    None,
                    None,
                    Some("kurzonc"),
                    "kurzonc",
                    Pronoun(LBID("5t"), "She / her", "she", "her", "her", "hers", "herself"),
                    Image(List(
                      ImageSize(144, 144, "https://a.ltrbxd.com/resized/avatar/twitter/img_144.jpg"),
                      ImageSize(300, 300, "https://a.ltrbxd.com/resized/avatar/twitter/img_300.jpg")
                    )),
                    "Member"
                  ),
                  FilmRelationship(
                    watched = false,
                    None,
                    liked = false,
                    None,
                    favorited = false,
                    Some(false),
                    None,
                    None,
                    None,
                    Some(Nil),
                    Some(Nil)
                  )
                )
              ))
            )
          ),
          ListEntrySummary(
            None,
            FilmSummary(
              LBID("6CCe"),
              "Sausage Party",
              None,
              Some(List(
                "La fiesta de las salchichas",
                "Sausage Party 3D",
                "Або в рот, або між булок!",
                "Party de Saucisses",
                "Саламена фиеста"
              )),
              Some(2016),
              Some(List(
                ContributorSummary(LBID("1Kwh"), "Conrad Vernon", None),
                ContributorSummary(LBID("2Lgr"), "Greg Tiernan", None)
              )),
              Some(Image(List(
                ImageSize(70,105,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-70-0-105-crop.jpg?k=e81bfb3242"),
                ImageSize(100,150,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-100-0-150-crop.jpg?k=de0374908d"),
                ImageSize(140,210,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-140-0-210-crop.jpg?k=6dff82ac2b"),
                ImageSize(200,300,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-200-0-300-crop.jpg?k=6dff82ac2b"),
                ImageSize(250,375,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-250-0-375-crop.jpg?k=498b50344d"),
                ImageSize(300,450,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-300-0-450-crop.jpg?k=498b50344d"),
                ImageSize(400,600,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-400-0-600-crop.jpg?k=30d30faa06"),
                ImageSize(500,750,"https://a.ltrbxd.com/resized/sm/upload/h4/fy/g1/ks/jDeDRLEa8JqB3xmKVy6q3bkmDt6-0-500-0-750-crop.jpg?k=e81bfb3242")
              ))),
              None,
              List(
                Link("letterboxd", "6CCe", "https://letterboxd.com/film/sausage-party/"),
                Link("tmdb", "223702", "https://www.themoviedb.org/movie/223702"),
                Link("imdb", "tt1700841", "http://www.imdb.com/title/tt1700841/")
              ),
              Some(List(
                MemberFilmRelationship(
                  MemberSummary(
                    LBID("4Ezf"),
                    "kurzonc",
                    None,
                    None,
                    Some("kurzonc"),
                    "kurzonc",
                    Pronoun(LBID("5t"), "She / her", "she", "her", "her", "hers", "herself"),
                    Image(List(
                      ImageSize(144, 144, "https://a.ltrbxd.com/resized/avatar/twitter/img_144.jpg"),
                      ImageSize(300, 300, "https://a.ltrbxd.com/resized/avatar/twitter/img_300.jpg")
                    )),
                    "Member"
                  ),
                  FilmRelationship(
                    watched = true,
                    Some(Time("2016-11-27T08:09:08Z")),
                    liked = false,
                    None,
                    favorited = false,
                    Some(false),
                    None,
                    Some(Time("2016-11-27T08:09:08Z")),
                    Some(1D),
                    Some(Nil),
                    Some(List(LBID("chrL1")))
                  )
                )
              ))
            )
          )
        ),
        List(Link("letterboxd", "lul1g", "https://letterboxd.com/kurzonc/list/sausage-dog/")),
        None
      )
    }
  }
}
