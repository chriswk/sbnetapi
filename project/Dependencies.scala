import sbt._
import Keys._

object Dependencies {
	val dispatchVersion = "0.11.0"
	val slf4jVersion = "1.7.5"
	val specs2 = "org.specs2" %% "specs2" % "2.2.3"
	val scalaMock3 = "org.scalamock" %% "scalamock-specs2-support" % "3.0.1"
	val typesafeLogging = "org.typesafe" % "scalaloggin-slf4j" % "1.0.1"
	val betaMax = "co.freeside" % "betamax" % "1.1.2"
	
	def dispatchDep(artifactName: String) = {
		"net.databinder.dispatch" %% s"dispatch-${artifactName}" % dispatchVersion
	}
	
	def slf4jDep(artifactName: String) = {
		"org.slf4j" % s"slf4j-${artifactName}" % slf4jVersion
	}
	
	val dispatchDependencies = Seq(dispatchDep("core"), dispatchDep("lift-json"))
	val loggingDependencies = Seq(slf4jDep("api"), slf4jDep("simple"))
	val testDependencies = Seq(specs2 % "test", betaMax % "test", "org.codehaus.groovy" % "groovy-all" % "1.8.8" % "test")
	val apiDependencies = dispatchDependencies ++ loggingDependencies ++ testDependencies
}