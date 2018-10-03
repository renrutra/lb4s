package lb4s.response

import lb4s.primitive.{LBID, Time}
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

import scala.io.Source

class ListEntriesResponseSpec extends WordSpec with Matchers {
  "A ListEntriesResponse" should {
    "be parsed from the response" in {
      val apiResponse = Source.fromFile("src/test/resources/list_entries_response.json").mkString
      val listEntriesResponse = Json.parse(apiResponse).as[ListEntriesResponse]

      listEntriesResponse shouldBe ListEntriesResponse(
        None,
        List(
          ListEntry(
            None,
            None,
            None,
            FilmSummary(
              LBID("9mfO"),
              "The Boss Baby",
              None,
              Some(List("Boss Baby", "Baby Boss", "Jefe en pañales", "O Poderoso Chefinho", "Baby-bossen", "Dzieciak rządzi")),
              Some(2017),
              Some(List(ContributorSummary(LBID("1Olx"), "Tom McGrath", None))),
              Some(Image(List(
                ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-70-0-105-crop.jpg?k=433e6f826e"),
                ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-100-0-150-crop.jpg?k=23eb29e91d"),
                ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-140-0-210-crop.jpg?k=050ed9dcb2"),
                ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-200-0-300-crop.jpg?k=479504829a"),
                ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-250-0-375-crop.jpg?k=479504829a"),
                ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-300-0-450-crop.jpg?k=dce4b97aae"),
                ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-400-0-600-crop.jpg?k=dce4b97aae"),
                ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/film-poster/2/2/3/0/5/0/223050-the-boss-baby-0-500-0-750-crop.jpg?k=433e6f826e")
              ))),
              None,
              List(
                Link("letterboxd", "9mfO", "https://letterboxd.com/film/the-boss-baby/"),
                Link("tmdb", "295693", "https://www.themoviedb.org/movie/295693"),
                Link("imdb", "tt3874544", "http://www.imdb.com/title/tt3874544/")
              ),
              Some(List(MemberFilmRelationship(
                MemberSummary(
                  LBID("gzTN"),
                  "Gcapp",
                  Some("George"),
                  None,
                  Some("George"),
                  "George",
                  Pronoun(LBID("3R"), "He / his", "he", "him", "his", "his", "himself"),
                  Image(List(
                    ImageSize(144, 144, "https://a.ltrbxd.com/resized/avatar/twitter/img_144.jpg"),
                    ImageSize(300, 300, "https://a.ltrbxd.com/resized/avatar/twitter/img_300.jpg")
                  )),
                  "Patron"
                ),
                FilmRelationship(
                  watched = true,
                  Some(Time("2017-12-29T05:09:58Z")),
                  liked = true,
                  Some(Time("2017-12-29T05:09:58Z")),
                  favorited = false,
                  Some(false),
                  None,
                  Some(Time("2017-12-29T05:09:58Z")),
                  Some(3.0),
                  Some(Nil),
                  Some(List(LBID("mWp2v")))
                )
              )))
            ),
            None
          ),
          ListEntry(
            None,
            None,
            None,
            FilmSummary(
              LBID("dYmm"),
              "Call Me by Your Name",
              None,
              Some(List(
                "Chiamami con il tuo nome",
                "以你的名字呼喚我",
                "Chama-me Pelo Teu Nome",
                "Призови ме с твоето име",
                "Me Chame Pelo Seu Nome",
                "Appelle-moi par ton nom",
                "Να με φωνάζεις με τ' όνομά σου",
                "Skrivena Ljubav",
                "Szólíts a neveden",
                "Kimi no Namae de Boku o Yonde",
                "Vadink mane savo vardu",
                "Tamte dni, tamte noce",
                "Spune-mi cum vrei",
                "Zovi me svojim imenom",
                "Зови меня своим именем",
                "Poklici me po svojem imenu",
                "콜 미 바이 유어 네임"
              )),
              Some(2017),
              Some(List(ContributorSummary(LBID("39ST"), "Luca Guadagnino", None))),
              Some(Image(List(
                ImageSize(70,105,"http://primer.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-70-0-105-crop.jpg?k=b3c17975f6"),
                ImageSize(100,150,"http://zardoz.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-100-0-150-crop.jpg?k=ee77a5f78c"),
                ImageSize(140,210,"http://oblivion.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-140-0-210-crop.jpg?k=10c17dd6ce"),
                ImageSize(200,300,"http://primer.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-200-0-300-crop.jpg?k=667f6d16cf"),
                ImageSize(250,375,"http://skyfall.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-250-0-375-crop.jpg?k=0dcfe2f5ae"),
                ImageSize(300,450,"http://oblivion.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-300-0-450-crop.jpg?k=b27aa7389e"),
                ImageSize(400,600,"http://skyfall.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-400-0-600-crop.jpg?k=badbee6175"),
                ImageSize(500,750,"http://primer.a.ltrbxd.com/resized/sm/upload/g9/9t/cc/7u/tcNniniS4rfqrLH0oORikJfnIwY-0-500-0-750-crop.jpg?k=b27aa7389e")
              ))),
              None,
              List(
                Link("letterboxd", "dYmm", "https://letterboxd.com/film/call-me-by-your-name/"),
                Link("tmdb", "398818", "https://www.themoviedb.org/movie/398818"),
                Link("imdb", "tt5726616", "http://www.imdb.com/title/tt5726616/")
              ),
              Some(List(MemberFilmRelationship(
                MemberSummary(
                  LBID("gzTN"),
                  "Gcapp",
                  Some("George"),
                  None,
                  Some("George"),
                  "George",
                  Pronoun(LBID("3R"), "He / his", "he", "him", "his", "his", "himself"),
                  Image(List(
                    ImageSize(144, 144, "https://a.ltrbxd.com/resized/avatar/twitter/img_144.jpg"),
                    ImageSize(300, 300, "https://a.ltrbxd.com/resized/avatar/twitter/img_300.jpg")
                  )),
                  "Patron"
                ),
                FilmRelationship(
                  watched = true,
                  Some(Time("2017-12-26T07:04:54Z")),
                  liked = true,
                  Some(Time("2017-12-26T07:04:55Z")),
                  favorited = true,
                  Some(false),
                  None,
                  Some(Time("2017-12-26T07:04:54Z")),
                  Some(5.0),
                  Some(List(LBID("nJEef"))),
                  Some(List(LBID("nJEef")))
                )
              )))),
            None
          )
        ),
        AFilmsMetadata(2, 2),
        List(FilmsMemberRelationship(
          MemberSummary(
            LBID("gzTN"),
            "Gcapp",
            Some("George"),
            None,
            Some("George"),
            "George",
            Pronoun(LBID("3R"), "He / his", "he", "him", "his", "his", "himself"),
            Image(List(
              ImageSize(144, 144, "https://a.ltrbxd.com/resized/avatar/twitter/img_144.jpg"),
              ImageSize(300, 300, "https://a.ltrbxd.com/resized/avatar/twitter/img_300.jpg")
            )),
            "Patron"
          ),
          FilmsRelationship(FilmsRelationshipCounts(2, 2))
        ))
      )
    }
  }
}
