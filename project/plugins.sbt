addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.3")

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

resolvers += Resolver.url("bintray-sbt-plugin-releases",
             url("http://dl.bintray.com/content/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.6.2")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.5.1")

resolvers ++= Seq(
  Classpaths.sbtPluginReleases,
  Opts.resolver.sonatypeReleases
)



addSbtPlugin("me.lessis" % "ls-sbt" % "0.1.3")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8")
