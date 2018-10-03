name := "lb4s"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.6"

description := "A Scala client for the Letterboxd API"

startYear := Some(2017)

licenses += "GPLv3" -> url("https://www.gnu.org/licenses/gpl-3.0.html")

organization := "com.github.renrutra"

organizationHomepage := Some(url("https://github.com/renrutra"))

libraryDependencies ++= List(
  "org.scalaj" %% "scalaj-http" % "2.4.0",
  "com.typesafe.play" %% "play-json" % "2.6.9",
  "commons-codec" % "commons-codec" % "1.11",
  "org.apache.commons" % "commons-dbcp2" % "2.3.0",
  "org.apache.httpcomponents" % "httpcore" % "4.4.9",
  "org.scalamock" %% "scalamock" % "4.1.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test
)
