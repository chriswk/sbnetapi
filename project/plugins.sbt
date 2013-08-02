addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.3")

addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.2.5")

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.6.2")

resolvers ++= Seq(
  Classpaths.sbtPluginReleases,
  Opts.resolver.sonatypeReleases
)



addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.3")
