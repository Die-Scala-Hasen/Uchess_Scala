import sbt.Keys.libraryDependencies

name := "Uchess_Scala"

version:="1.0"

scalaVersion:="2.11.7"

libraryDependencies += "junit" % "junit" % "4.8" % "test"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "2.4.14" % "test"
)

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.0"

libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11+"

libraryDependencies := {
  libraryDependencies.value ++ Seq(
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
    "org.scala-lang.modules" %% "scala-swing" % "2.0.0-M2")
}