val scala3Version = "3.2.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "simplehosting.compositor.client",
    version := "0.1.0-SNAPSHOT",

    organization := "io.github.heavypunk",
    homepage := Some(url("https://github.com/HeavyPunk/simple-hosting.compositor.client")),
    scmInfo := Some(ScmInfo(url("https://github.com/HeavyPunk/simple-hosting.compositor.client"), "git@github.com/HeavyPunk/simple-hosting.compositor.client.git")),
    developers := List(Developer("HeavyPunk", "HeavyPunk", "heavypunk@simplehosting.com", url("https://github.com/HeavyPunk"))),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),

    publishMavenStyle := true,

    crossPaths := false,

    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeOssSnapshots.head
      else
        Opts.resolver.sonatypeStaging
    ),

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,
    libraryDependencies += "com.google.code.gson" % "gson" % "2.10.1",
  )
