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