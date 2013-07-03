name := "sbnetapi"

version := "0.1-SNAPSHOT"

description := "A Scala frontend to battle.net apis"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "net.databinder.dispatch" %% "dispatch-core" % "0.10.1",
  "net.liftweb" %% "lift-json" % "2.5.1",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "org.slf4j" % "slf4j-api" % "1.7.4",
  "org.slf4j" % "slf4j-simple" % "1.7.4"
)
