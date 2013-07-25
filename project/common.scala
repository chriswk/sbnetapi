import sbt._
import Keys._

object common {
	val commonSettings = Seq(
		organization := "com.chriswk"
	)
	
	def apiProject(name: String) = (
		Project(name, file(name))
		settings(commonSettings:_*)
	)
}