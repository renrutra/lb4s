package lb4s.response

import lb4s.primitive.{Cursor, FilmContributionType, LBID}
import org.scalatest.{Matchers, WordSpec}
import play.api.libs.json.Json

import scala.io.Source

class SearchResponseSpec extends WordSpec with Matchers {
  import FilmContributionType._

  "A SearchResponse" should {
    "be parsed from the response" in {
      val apiResponse = Source.fromFile("src/test/resources/search_response.json").mkString
      val searchResponse = Json.parse(apiResponse).as[SearchResponse]

      searchResponse shouldBe SearchResponse(
        Some(Cursor("start=4")),
        List(
          ContributorSearchItem(
            "ContributorSearchItem",
            449.0143127441406,
            Contributor(
              LBID("2DUX"),
              "Charles Henri Ford",
              ContributorStatistics(List(ContributionStatistics(Actor,2), ContributionStatistics(Director,1))),
              List(
                Link("letterboxd", "2DUX", "https://letterboxd.com/actor/charles-henri-ford/"),
                Link("tmdb", "1313615", "https://www.themoviedb.org/person/1313615")
              )
            )
          ),
          MemberSearchItem(
            "MemberSearchItem",
            24.74416732788086,
            MemberSummary(
              LBID("4jS1"),
              "trollfree",
              None,
              None,
              Some("trollfree"),
              "trollfree",
              Pronoun(LBID("3R"), "He / his", "he", "him", "his", "his", "himself"),
              Image(List(
                ImageSize(144,144,"https://a.ltrbxd.com/resized/avatar/twitter/1/0/2/9/6/9/shard/http___pbs.twimg.com_profile_images_969224506010152960_qK19JNS_-0-144-0-144-crop.jpg?k=972a024142"),
                ImageSize(300,300,"https://a.ltrbxd.com/resized/avatar/twitter/1/0/2/9/6/9/shard/http___pbs.twimg.com_profile_images_969224506010152960_qK19JNS_-0-300-0-300-crop.jpg?k=085cfbc781")
              )),
              "Member"
            )
          ),
          FilmSearchItem(
            "FilmSearchItem",
            23.483427047729492,
            FilmSummary(
              LBID("7XiG"),
              "Johnny Minotaur",
              None,
              None,
              Some(1971),
              Some(List(ContributorSummary(LBID("2DUX"), "Charles Henri Ford", None))),
              Some(Image(List(
                ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-70-0-105-crop.jpg?k=f7bafd6934"),
                ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-100-0-150-crop.jpg?k=d148f2166b"),
                ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-140-0-210-crop.jpg?k=25fc34aed3"),
                ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-200-0-300-crop.jpg?k=b53fc04c3a"),
                ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-250-0-375-crop.jpg?k=11c067e6e1"),
                ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-300-0-450-crop.jpg?k=53458618e2"),
                ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-400-0-600-crop.jpg?k=1246d6d8e4"),
                ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/film-poster/1/8/9/6/2/5/189625-johnny-minotaur-0-500-0-750-crop.jpg?k=8041528e11")
              ))),
              None,
              List(
                Link("letterboxd", "7XiG", "https://letterboxd.com/film/johnny-minotaur/"),
                Link("tmdb", "266374", "https://www.themoviedb.org/movie/266374"),
                Link("imdb", "tt0222068", "http://www.imdb.com/title/tt0222068/")
              ),
              Some(Nil)
            )
          ),
          ListSearchItem(
            "ListSearchItem",
            16.124168395996094,
            ListSummary(
              LBID("3wKW"),
              "The Complete Criterion Collection",
              1081,
              published = true,
              ranked = false,
              Some("The Criterion Collection is a video distribution company."),
              Some(false),
              MemberSummary(
                LBID("PSz"),
                "joshb",
                Some("Josh"),
                None,
                Some("Josh"),
                "Josh",
                Pronoun(LBID("3R"), "He / his", "he", "him", "his", "his", "himself"),
                Image(List(
                  ImageSize(144,144,"https://secure.gravatar.com/avatar/caa2727b0490423d174dd6950ddf493f?rating=PG&size=144&border=&default=https%3A%2F%2Fletterboxd.com%2Fstatic%2Fimg%2Favatar144.d9bdbd93.png"),
                  ImageSize(300,300,"https://secure.gravatar.com/avatar/caa2727b0490423d174dd6950ddf493f?rating=PG&size=300&border=&default=https%3A%2F%2Fletterboxd.com%2Fstatic%2Fimg%2Favatar300.e684c991.png")
                )),
                "Patron"
              ),
              None,
              List(
                ListEntrySummary(None, FilmSummary(
                  LBID("29Ei"),
                  "Grand Illusion",
                  Some("La Grande Illusion"),
                  Some(List("A Grande Ilusão", "Die große Illusion", "La grande illusione", "Вeликая иллюзия", "Marea iluzie")),
                  Some(1937),
                  Some(List(ContributorSummary(LBID("2ro1"), "Jean Renoir", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://skyfall.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-70-0-105-crop.jpg?k=971d3f7187"),
                    ImageSize(100,150,"http://oblivion.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-100-0-150-crop.jpg?k=c05abbd76d"),
                    ImageSize(140,210,"http://primer.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-140-0-210-crop.jpg?k=4f7e48db2d"),
                    ImageSize(200,300,"http://skyfall.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-200-0-300-crop.jpg?k=4f7e48db2d"),
                    ImageSize(250,375,"http://zardoz.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-250-0-375-crop.jpg?k=d3fd9f276c"),
                    ImageSize(300,450,"http://primer.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-300-0-450-crop.jpg?k=d3fd9f276c"),
                    ImageSize(400,600,"http://zardoz.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-400-0-600-crop.jpg?k=7f5850d19b"),
                    ImageSize(500,750,"http://skyfall.a.ltrbxd.com/resized/sm/upload/hr/bh/2r/vu/bXYsO5mvGYFKSmnHHHGc5AIlStI-0-500-0-750-crop.jpg?k=971d3f7187")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "29Ei", "https://letterboxd.com/film/grand-illusion/"),
                    Link("tmdb", "777", "https://www.themoviedb.org/movie/777"),
                    Link("imdb", "tt0028950", "http://www.imdb.com/title/tt0028950/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("2axi"),
                  "Seven Samurai",
                  Some("七人の侍"),
                  Some(List("Sieben Samurai", "I sette samurai", "A hét szamuráj", "Los siete samurais", "Os Sete Samurais", "Siedmiu samurajów", "Седемте самураи", "Οι επτά σαμουράι", "Yedi Samuray-Kanli Pirinç", "7 Vo Si", "Shichinin no samurai", "Les 7 samouraïs", "七武士", "7인의 사무라이", "The Magnificent Seven")),
                  Some(1954),
                  Some(List(ContributorSummary(LBID("7l3"), "Akira Kurosawa", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-70-0-105-crop.jpg?k=cfed3e0759"),
                    ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-100-0-150-crop.jpg?k=5691e16868"),
                    ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-140-0-210-crop.jpg?k=9a8338b01b"),
                    ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-200-0-300-crop.jpg?k=cfed3e0759"),
                    ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-250-0-375-crop.jpg?k=e64573c773"),
                    ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-300-0-450-crop.jpg?k=97df79eb5a"),
                    ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-400-0-600-crop.jpg?k=cbcd7c15ef"),
                    ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/sm/upload/ji/5q/0k/rv/v6xrz4fr92KY1oNC3HsEvrsvR1n-0-500-0-750-crop.jpg?k=829b33c145")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "2axi", "https://letterboxd.com/film/seven-samurai/"),
                    Link("tmdb", "346", "https://www.themoviedb.org/movie/346"),
                    Link("imdb", "tt0047478", "http://www.imdb.com/title/tt0047478/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("29ea"),
                  "The Lady Vanishes",
                  None,
                  Some(List("贵妇失踪案", "La signora scompare", "失踪的女人", "La dama desaparece", "A Dama Oculta", "Леди исчезает")),
                  Some(1938),
                  Some(List(ContributorSummary(LBID("2Jgz"), "Alfred Hitchcock", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-70-0-105-crop.jpg?k=e4125f2fa0"),
                    ImageSize(100,150,"http://oblivion.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-100-0-150-crop.jpg?k=96df8c1771"),
                    ImageSize(140,210,"http://primer.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-140-0-210-crop.jpg?k=4bc1eaa0c3"),
                    ImageSize(200,300,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-200-0-300-crop.jpg?k=658b298a76"),
                    ImageSize(250,375,"http://zardoz.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-250-0-375-crop.jpg?k=63591e1f34"),
                    ImageSize(300,450,"http://primer.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-300-0-450-crop.jpg?k=63591e1f34"),
                    ImageSize(400,600,"http://zardoz.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-400-0-600-crop.jpg?k=1d6d7758c7"),
                    ImageSize(500,750,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/2/1/3/51213-the-lady-vanishes-0-500-0-750-crop.jpg?k=e4125f2fa0")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "29ea", "https://letterboxd.com/film/the-lady-vanishes/"),
                    Link("tmdb", "940", "https://www.themoviedb.org/movie/940"),
                    Link("imdb", "tt0030341", "http://www.imdb.com/title/tt0030341/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("20NA"),
                  "Amarcord",
                  None,
                  Some(List("I Remember", "童年事，我记得", "当年事", "我记得，想当年", "我的回忆")),
                  Some(1973),
                  Some(List(ContributorSummary(LBID("2qTn"), "Federico Fellini", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://primer.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-70-0-105-crop.jpg?k=656b4a35e7"),
                    ImageSize(100,150,"http://zardoz.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-100-0-150-crop.jpg?k=f43cd13514"),
                    ImageSize(140,210,"http://oblivion.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-140-0-210-crop.jpg?k=509dadc1ca"),
                    ImageSize(200,300,"http://primer.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-200-0-300-crop.jpg?k=509dadc1ca"),
                    ImageSize(250,375,"http://skyfall.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-250-0-375-crop.jpg?k=8776563809"),
                    ImageSize(300,450,"http://oblivion.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-300-0-450-crop.jpg?k=8776563809"),
                    ImageSize(400,600,"http://skyfall.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-400-0-600-crop.jpg?k=49d72b786a"),
                    ImageSize(500,750,"http://primer.a.ltrbxd.com/resized/film-poster/4/7/9/7/3/47973-amarcord-0-500-0-750-crop.jpg?k=49d72b786a")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "20NA", "https://letterboxd.com/film/amarcord/"),
                    Link("tmdb", "7857", "https://www.themoviedb.org/movie/7857"),
                    Link("imdb", "tt0071129", "http://www.imdb.com/title/tt0071129/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("2b1C"),
                  "The 400 Blows",
                  Some("Les Quatre Cents Coups"),
                  Some(List("Les 400 coups", "I quattrocento colpi", "De vierhonderd slagen", "400 batów", "The Four Hundred Blows", "四百下", "胡作非为", "På vei mot livet", "Os Incompreendidos", "大人は判ってくれない", "Los 400 golpes", "Nikdo mne nemá rád")),
                  Some(1959),
                  Some(List(ContributorSummary(LBID("es1"), "François Truffaut", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-70-0-105-crop.jpg?k=87ad0d4f89"),
                    ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-100-0-150-crop.jpg?k=66ba0700f0"),
                    ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-140-0-210-crop.jpg?k=0b887d99f6"),
                    ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-200-0-300-crop.jpg?k=66ba0700f0"),
                    ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-250-0-375-crop.jpg?k=b0dbfd9aea"),
                    ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-300-0-450-crop.jpg?k=b2f5e7bad0"),
                    ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-400-0-600-crop.jpg?k=3ed0b673d2"),
                    ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/sm/upload/73/wu/j8/94/nKVXTcCtOc3Zuu4yCEDMOUyeXfH-0-500-0-750-crop.jpg?k=3ed0b673d2")
                  ))),
                  Some(LBID("2Nn")),
                  List(
                    Link("letterboxd", "2b1C", "https://letterboxd.com/film/the-400-blows/"),
                    Link("tmdb", "147", "https://www.themoviedb.org/movie/147"),
                    Link("imdb", "tt0053198", "http://www.imdb.com/title/tt0053198/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("29UA"),
                  "Beauty and the Beast",
                  Some("La belle et la bête"),
                  Some(List("La Bella y la Bestia", "A Bela E a Fera", "Es war einmal", "La bella e la bestia", "Die Schöne und das Biest", "Es war einmal - Die Schöne und die Bestie")),
                  Some(1946),
                  Some(List(ContributorSummary(LBID("1cND"), "Jean Cocteau", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-70-0-105-crop.jpg?k=a3bdb10952"),
                    ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-100-0-150-crop.jpg?k=95d90b5540"),
                    ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-140-0-210-crop.jpg?k=88f2cb1677"),
                    ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-200-0-300-crop.jpg?k=59bae9a0c4"),
                    ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-250-0-375-crop.jpg?k=20678fff80"),
                    ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-300-0-450-crop.jpg?k=2225d4be2d"),
                    ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-400-0-600-crop.jpg?k=698a677e45"),
                    ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/sm/upload/6u/xn/xm/q3/qi4V20bYyclriiOXzsfbejypy8u-0-500-0-750-crop.jpg?k=7131c4cb90")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "29UA", "https://letterboxd.com/film/beauty-and-the-beast/"),
                    Link("tmdb", "648", "https://www.themoviedb.org/movie/648"),
                    Link("imdb", "tt0038348", "http://www.imdb.com/title/tt0038348/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("1UXE"),
                  "A Night to Remember",
                  None,
                  Some(List("Titanic - A Night to Remember", "La última noche del Titánic", "Somente Deus por Testemunha")),
                  Some(1958),
                  Some(List(ContributorSummary(LBID("1W7j"), "Roy Ward Baker", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://oblivion.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-70-0-105-crop.jpg?k=eb0915de19"),
                    ImageSize(100,150,"http://skyfall.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-100-0-150-crop.jpg?k=7cb673fe6a"),
                    ImageSize(140,210,"http://zardoz.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-140-0-210-crop.jpg?k=7cb673fe6a"),
                    ImageSize(200,300,"http://oblivion.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-200-0-300-crop.jpg?k=a4f8a7a791"),
                    ImageSize(250,375,"http://primer.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-250-0-375-crop.jpg?k=1dd8ca2b87"),
                    ImageSize(300,450,"http://zardoz.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-300-0-450-crop.jpg?k=1dd8ca2b87"),
                    ImageSize(400,600,"http://primer.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-400-0-600-crop.jpg?k=78c31e52fd"),
                    ImageSize(500,750,"http://oblivion.a.ltrbxd.com/resized/sm/upload/m3/ie/3t/g5/8foJteZ4PBk1YIwI4hEVoRxTryx-0-500-0-750-crop.jpg?k=eb0915de19")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "1UXE", "https://letterboxd.com/film/a-night-to-remember/"),
                    Link("tmdb", "10971", "https://www.themoviedb.org/movie/10971"),
                    Link("imdb", "tt0051994", "http://www.imdb.com/title/tt0051994/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("1Vha"),
                  "The Killer",
                  Some("喋血雙雄"),
                  Some(List("Blast Killer", "첩혈쌍웅", "Наемный убийца", "Dip huet seung hung")),
                  Some(1989),
                  Some(List(ContributorSummary(LBID("34r9"), "John Woo", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://primer.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-70-0-105-crop.jpg?k=03fe05dd39"),
                    ImageSize(100,150,"http://zardoz.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-100-0-150-crop.jpg?k=a95d433f5e"),
                    ImageSize(140,210,"http://oblivion.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-140-0-210-crop.jpg?k=252e08f4c1"),
                    ImageSize(200,300,"http://primer.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-200-0-300-crop.jpg?k=f353f8af6f"),
                    ImageSize(250,375,"http://skyfall.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-250-0-375-crop.jpg?k=8a23bc4b34"),
                    ImageSize(300,450,"http://oblivion.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-300-0-450-crop.jpg?k=09f384fd81"),
                    ImageSize(400,600,"http://skyfall.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-400-0-600-crop.jpg?k=2c0e5f9f43"),
                    ImageSize(500,750,"http://primer.a.ltrbxd.com/resized/sm/upload/9l/66/lq/52/E2BPXibw2jkE4ZAt0cakIOUgH5-0-500-0-750-crop.jpg?k=a6cb830ebe")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "1Vha", "https://letterboxd.com/film/the-killer/"),
                    Link("tmdb", "10835", "https://www.themoviedb.org/movie/10835"),
                    Link("imdb", "tt0097202", "http://www.imdb.com/title/tt0097202/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("1T6a"),
                  "Hard Boiled",
                  Some("辣手神探"),
                  Some(List("Lat sau san taam", "à toute épreuve")),
                  Some(1992),
                  Some(List(ContributorSummary(LBID("34r9"), "John Woo", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://primer.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-70-0-105-crop.jpg?k=14861110ae"),
                    ImageSize(100,150,"http://zardoz.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-100-0-150-crop.jpg?k=c5774e06c9"),
                    ImageSize(140,210,"http://oblivion.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-140-0-210-crop.jpg?k=f96517a1ec"),
                    ImageSize(200,300,"http://primer.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-200-0-300-crop.jpg?k=38cae21cbf"),
                    ImageSize(250,375,"http://skyfall.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-250-0-375-crop.jpg?k=8cadf113a2"),
                    ImageSize(300,450,"http://oblivion.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-300-0-450-crop.jpg?k=8cadf113a2"),
                    ImageSize(400,600,"http://skyfall.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-400-0-600-crop.jpg?k=221a6454ba"),
                    ImageSize(500,750,"http://primer.a.ltrbxd.com/resized/sm/upload/sx/3x/gd/hd/pH1w6HQIxVqvx40dcUJIvFJb0D2-0-500-0-750-crop.jpg?k=14861110ae")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "1T6a", "https://letterboxd.com/film/hard-boiled/"),
                    Link("tmdb", "11782", "https://www.themoviedb.org/movie/11782"),
                    Link("imdb", "tt0104684", "http://www.imdb.com/title/tt0104684/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("1bsG"),
                  "Walkabout",
                  None,
                  None,
                  Some(1971),
                  Some(List(ContributorSummary(LBID("2t69"), "Nicolas Roeg", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://primer.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-70-0-105-crop.jpg?k=22b8187fdd"),
                    ImageSize(100,150,"http://zardoz.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-100-0-150-crop.jpg?k=7a4b1320ea"),
                    ImageSize(140,210,"http://oblivion.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-140-0-210-crop.jpg?k=a73f49bd09"),
                    ImageSize(200,300,"http://primer.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-200-0-300-crop.jpg?k=f7716b91f3"),
                    ImageSize(250,375,"http://skyfall.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-250-0-375-crop.jpg?k=66480d2f3b"),
                    ImageSize(300,450,"http://oblivion.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-300-0-450-crop.jpg?k=903c378cd7"),
                    ImageSize(400,600,"http://skyfall.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-400-0-600-crop.jpg?k=82d5693fbe"),
                    ImageSize(500,750,"http://primer.a.ltrbxd.com/resized/sm/upload/6t/us/w1/6h/8wX6jmqOx6YZGYh6QF8VgpTifI4-0-500-0-750-crop.jpg?k=edbe696a3a")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "1bsG", "https://letterboxd.com/film/walkabout/"),
                    Link("tmdb", "36040", "https://www.themoviedb.org/movie/36040"),
                    Link("imdb", "tt0067959", "http://www.imdb.com/title/tt0067959/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("2ahO"),
                  "The Seventh Seal",
                  Some("Det sjunde inseglet"),
                  Some(List("Das siebente Siegel", "Il Settimo Sigillo", "Siódma pieczęć", "El séptimo sello", "第七封印", "Det syvende segl")),
                  Some(1957),
                  Some(List(ContributorSummary(LBID("35NP"), "Ingmar Bergman", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://primer.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-70-0-105-crop.jpg?k=911815a704"),
                    ImageSize(100,150,"http://zardoz.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-100-0-150-crop.jpg?k=8bef5ae7a3"),
                    ImageSize(140,210,"http://oblivion.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-140-0-210-crop.jpg?k=8bef5ae7a3"),
                    ImageSize(200,300,"http://primer.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-200-0-300-crop.jpg?k=911815a704"),
                    ImageSize(250,375,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-250-0-375-crop.jpg?k=911815a704"),
                    ImageSize(300,450,"http://oblivion.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-300-0-450-crop.jpg?k=d469c2575a"),
                    ImageSize(400,600,"http://skyfall.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-400-0-600-crop.jpg?k=74bcd6de5e"),
                    ImageSize(500,750,"http://primer.a.ltrbxd.com/resized/film-poster/5/1/6/2/0/51620-the-seventh-seal-0-500-0-750-crop.jpg?k=74bcd6de5e")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "2ahO", "https://letterboxd.com/film/the-seventh-seal/"),
                    Link("tmdb", "490", "https://www.themoviedb.org/movie/490"),
                    Link("imdb", "tt0050976", "http://www.imdb.com/title/tt0050976/")
                  ),
                  Some(Nil)
                )),
                ListEntrySummary(None, FilmSummary(
                  LBID("1UOs"),
                  "This Is Spinal Tap",
                  None,
                  Some(List("Spinal Tap", "腰椎穿刺传奇", "刺脊乐队", "Isto é Spinal Tap")),
                  Some(1984),
                  Some(List(ContributorSummary(LBID("385L"), "Rob Reiner", None))),
                  Some(Image(List(
                    ImageSize(70,105,"http://zardoz.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-70-0-105-crop.jpg?k=f1ac7c24ea"),
                    ImageSize(100,150,"http://primer.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-100-0-150-crop.jpg?k=1519ddec98"),
                    ImageSize(140,210,"http://skyfall.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-140-0-210-crop.jpg?k=13ebbbe820"),
                    ImageSize(200,300,"http://zardoz.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-200-0-300-crop.jpg?k=ee6ef1d54d"),
                    ImageSize(250,375,"http://oblivion.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-250-0-375-crop.jpg?k=fb0b1171f0"),
                    ImageSize(300,450,"http://skyfall.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-300-0-450-crop.jpg?k=fd3603b5f8"),
                    ImageSize(400,600,"http://oblivion.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-400-0-600-crop.jpg?k=2f359ed2a7"),
                    ImageSize(500,750,"http://zardoz.a.ltrbxd.com/resized/film-poster/4/5/6/7/2/45672-this-is-spinal-tap-0-500-0-750-crop.jpg?k=be9f52f94d")
                  ))),
                  None,
                  List(
                    Link("letterboxd", "1UOs", "https://letterboxd.com/film/this-is-spinal-tap/"),
                    Link("tmdb", "11031", "https://www.themoviedb.org/movie/11031"),
                    Link("imdb", "tt0088258", "http://www.imdb.com/title/tt0088258/")
                  ),
                  Some(Nil)
                ))
              ),
              Some("<p>The Criterion Collection is a video distribution company.</p>")
            )
          )
        )
      )

    }
  }
}
