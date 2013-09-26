import Dependencies._

organization := "com.chriswk"

name := "sbnetapi"

description := "A Scala frontend to battle.net apis"

scalaVersion := "2.10.2"

val gitHeadCommitSha =
  settingKey[String]("current git commit SHA")
  
val gitDescribe =
  settingKey[String]("current git describe")

gitHeadCommitSha in ThisBuild :=
  Process("git rev-parse HEAD").lines.head
  
gitDescribe in ThisBuild :=
  Process("git describe").lines.head
  
version in ThisBuild :=
  "0.0.1-SNAPSHOT"


seq(lsSettings :_*)

seq(bintrayPublishSettings:_*)

libraryDependencies ++= apiDependencies

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
