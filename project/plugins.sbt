addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8" % "0.16.2")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.1")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.11.0")

addSbtPlugin("com.github.sbt"   % "sbt-jacoco"  % "3.4.0")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.6.4")

libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value
