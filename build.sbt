import Dependencies._
import common._

organization := "com.chriswk"

name := "sbnetapi"

description := "A Scala frontend to battle.net apis"

scalaVersion := "2.10.1"

val gitHeadCommitSha =
  settingKey[String]("current git commit SHA")
  
val gitDescribe =
  settingKey[String]("current git describe")

gitHeadCommitSha in ThisBuild :=
  Process("git rev-parse HEAD").lines.head
  
gitDescribe in ThisBuild :=
  Process("git describe").lines.head
  
version in ThisBuild :=
  "1.0-" + gitHeadCommitSha.value

lazy val backend = (
  apiProject("api")
  settings(
    libraryDependencies ++= apiDependencies:_*
  )
)


