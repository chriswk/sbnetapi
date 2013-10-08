import Dependencies._

organization := "com.chriswk"

name := "sbnetapi"

description := "A Scala frontend to battle.net apis"

scalaVersion := "2.10.2"
  
val chriswkArtifactory = "http://artifactory.chriswk.com/artifactory/"

seq(lsSettings :_*)

seq(releaseSettings :_*)

(LsKeys.tags in LsKeys.lsync) := Seq("battlenet", "worldofwarcraft", "dispatch", "lift-json")

(externalResolvers in LsKeys.lsync) := Seq(
  "com.chriswk Artifactory release" at chriswkArtifactory + "libs-release-local",
  "com.chriswk Artifactory snapshots" at chriswkArtifactory + "libs-snapshot-local"
)

libraryDependencies ++= apiDependencies

resolvers += "Sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials") 

publishTo := {
 if (version.value.trim.endsWith("SNAPSHOT")) {
    Some("chriswkSnapshots" at chriswkArtifactory + "libs-snapshot-local")
 } else {
    Some("chriswkRelease" at chriswkArtifactory + "libs-release-local")
 }
}