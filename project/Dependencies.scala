import sbt._
import Keys._

object Dependencies {
	val dispatchVersion = "0.11.0"
	val slf4jVersion = "1.7.5"
	val specs2 = "org.specs2" %% "specs2" % "2.1.1"
	val typesafeLogging = "org.typesafe" % "scalaloggin-slf4j" % "1.0.1"
	
	def dispatchDep(artifactName: String) = {
		"net.databinder.dispatch" %% s"dispatch-${artifactName}" % dispatchVersion
	}
	
	def slf4jDep(artifactName: String) = {
		"org.slf4j" % s"slf4j-${artifactName}" % slf4jVersion
	}
	
	val dispatchDependencies = Seq(dispatchDep("core"), dispatchDep("lift-json"))
	val loggingDependencies = Seq(slf4jDep("api"), slf4jDep("simple"))
	val apiDependencies = dispatchDependencies ++ loggingDependencies ++ Seq(specs2 % "test")
}