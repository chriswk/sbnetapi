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
  
val chriswkArtifactory = "http://artifactory.chriswk.com/artifactory/"


version in ThisBuild :=
  "0.0.1-SNAPSHOT"


seq(lsSettings :_*)

(LsKeys.tags in LsKeys.lsync) := Seq("battlenet", "worldofwarcraft", "dispatch", "lift-json")

(externalResolvers in LsKeys.lsync) := Seq(
  "com.chriswk Artifactory release" at chriswkArtifactory + "libs-release-local",
  "com.chriswk Artifactory snapshots" at chriswkArtifactory + "libs-snapshot-local"
)

libraryDependencies ++= apiDependencies

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials") 

publishTo := {
 if (version.value.trim.endsWith("SNAPSHOT")) {
    Some("chriswkSnapshots" at chriswkArtifactory + "libs-snapshot-local")
 } else {
    Some("chriswkRelease" at chriswkArtifactory + "libs-release-local")
 }
}

