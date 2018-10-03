package lb4s.response

import lb4s.primitive.LBID
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

import scala.io.Source

class MemberSpec extends WordSpec with Matchers {
  "A Member" should {
    "be parsed from the response" in {
      val apiResponse = Source.fromFile("src/test/resources/member.json").mkString
      val member = Json.parse(apiResponse).as[Member]

      member shouldBe Member(
        LBID("6ADL"),
        "trenur",
        Some("Bob"),
        None,
        Some("Bob"),
        "Bob",
        Pronoun(LBID("3R"), "He / his", "he", "him", "his", "his", "himself"),
        None,
        Some(""),
        Some("Norway"),
        None,
        Image(List(
          ImageSize(144,144,"https://secure.gravatar.com/avatar/f119283e652c0d1e4bbb427e50f8290c?rating=PG&size=144&border="),
          ImageSize(300,300,"https://secure.gravatar.com/avatar/f119283e652c0d1e4bbb427e50f8290c?rating=PG&size=300&border=")
        )),
        Some(
          Image(List(
            ImageSize(960,540,"http://letterboxd-assets.s3.amazonaws.com/resized/sm/upload/zk/j8/ov/z3/my-own-private-idaho-0-960-0-540-crop.jpg?k=e959315429"),
            ImageSize(1200,675,"http://letterboxd-assets.s3.amazonaws.com/resized/sm/upload/zk/j8/ov/z3/my-own-private-idaho-0-1200-0-675-crop.jpg?k=7aaeef1d9c")
          ))
        ),
        Some(0.5518518518518518),
        "Patron",
        List(
          FilmSummary(
            LBID("2ak4"),
            "My Own Private Idaho",
            None,
            Some(List(
              "Belli e Dannati",
              "不羁的天空",
              "属于我的爱达荷",
              "我私人的爱达荷",
              "男人的一半还是男人",
              "Garotos de Programa",
              "Mi mundo privado",
              "Idaho: El camino de mis sueños",
              "A Caminho de Idaho",
              "Mi Idaho privado"
            )),
            Some(1991),
            Some(List(ContributorSummary(LBID("e49"), "Gus Van Sant", None))),
            Some(Image(List(
              ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-70-0-105-crop.jpg?k=b815570344"),
              ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-100-0-150-crop.jpg?k=c7b2c2042e"),
              ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-140-0-210-crop.jpg?k=0e29a9f91a"),
              ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-200-0-300-crop.jpg?k=c7b2c2042e"),
              ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-250-0-375-crop.jpg?k=b4d7bc4db1"),
              ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-300-0-450-crop.jpg?k=6a430ba216"),
              ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-400-0-600-crop.jpg?k=aa9d286c71"),
              ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/film-poster/5/1/6/3/4/51634-my-own-private-idaho-0-500-0-750-crop.jpg?k=aa9d286c71")
            ))),
            None,
            List(
              Link("letterboxd", "2ak4", "https://letterboxd.com/film/my-own-private-idaho/"),
              Link("tmdb", "468", "https://www.themoviedb.org/movie/468"),
              Link("imdb", "tt0102494", "http://www.imdb.com/title/tt0102494/")
            ),
            Some(Nil)
          ),
          FilmSummary(
            LBID("7BHu"),
            "Narcissus",
            None,
            Some(List("Narcisse")),
            Some(1983),
            Some(List(ContributorSummary(LBID("2VzD"), "Norman McLaren", None))),
            Some(Image(List(
              ImageSize(70,105,"http://oblivion.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-70-0-105-crop.jpg?k=b1b8d380d3"),
              ImageSize(100,150,"http://skyfall.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-100-0-150-crop.jpg?k=401cebe8c0"),
              ImageSize(140,210,"http://zardoz.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-140-0-210-crop.jpg?k=abcabee966"),
              ImageSize(200,300,"http://oblivion.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-200-0-300-crop.jpg?k=42551a0467"),
              ImageSize(250,375,"http://primer.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-250-0-375-crop.jpg?k=b4aa516452"),
              ImageSize(300,450,"http://zardoz.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-300-0-450-crop.jpg?k=d7b1d42e21"),
              ImageSize(400,600,"http://primer.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-400-0-600-crop.jpg?k=4906a2ea5d"),
              ImageSize(500,750,"http://oblivion.a.ltrbxd.com/resized/film-poster/1/8/1/3/2/2/181322-narcissus-0-500-0-750-crop.jpg?k=c55e6fcd3b")
            ))),
            None,
            List(
              Link("letterboxd", "7BHu", "https://letterboxd.com/film/narcissus/"),
              Link("tmdb", "257563", "https://www.themoviedb.org/movie/257563"),
              Link("imdb", "tt0203725", "http://www.imdb.com/title/tt0203725/")
            ),
            Some(Nil)
          )
        ),
        None,
        List(Link("letterboxd", "6ADL", "https://letterboxd.com/trenur/")),
        privateWatchlist = false,
        Some("")
      )
    }
  }
}
