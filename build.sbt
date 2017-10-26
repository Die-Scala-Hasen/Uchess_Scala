import sbt.Keys.libraryDependencies

name := "Uchess_Scala"

version := "1.0"

scalaVersion := "2.12.1"


resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"



libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor_2.10" % "2.2-M1" ,
  "org.scala-lang" % "scala-swing" % "2.11+",
  "org.scala-js" %% "scalajs-test-interface" % "0.6.14",
  "org.scalatest" %% "scalatest" % "3.0.1", //version changed as these the only versions supported by 2.12
  "com.novocode" % "junit-interface" % "0.11",
  "org.scala-lang" % "scala-library" % scalaVersion.value
)