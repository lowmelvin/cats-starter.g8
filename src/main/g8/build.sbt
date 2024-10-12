val CatsVersion              = "2.12.0"
val CatsEffectVersion        = "3.5.4"
val CatsEffectTestKitVersion = "3.5.4"
val CirceVersion             = "0.14.10"
val CirceFs2Version          = "0.14.1"
val CirceConfigVersion       = "0.10.1"
val Fs2Version               = "3.11.0"
val Http4sVersion            = "0.23.28"
val Log4CatsVersion          = "2.7.0"
val LogbackVersion           = "1.5.10"
val MunitVersion             = "1.0.2"
val MunitCatsEffectVersion   = "2.0.0"
val WeaverCatsVersion        = "0.8.4"

ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scala_version$"

lazy val root = (project in file("."))
  .settings(
    name    := "$name$",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "org.typelevel"       %% "cats-core"           % CatsVersion,
      "org.typelevel"       %% "cats-effect"         % CatsEffectVersion,
      "co.fs2"              %% "fs2-core"            % Fs2Version,
      "co.fs2"              %% "fs2-io"              % Fs2Version,
      "io.circe"            %% "circe-core"          % CirceVersion,
      "io.circe"            %% "circe-generic"       % CirceVersion,
      "io.circe"            %% "circe-parser"        % CirceVersion,
      "io.circe"            %% "circe-literal"       % CirceVersion,
      "io.circe"            %% "circe-fs2"           % CirceFs2Version,
      "io.circe"            %% "circe-config"        % CirceConfigVersion,
      "org.http4s"          %% "http4s-ember-client" % Http4sVersion,
      "org.http4s"          %% "http4s-ember-server" % Http4sVersion,
      "org.http4s"          %% "http4s-dsl"          % Http4sVersion,
      "org.http4s"          %% "http4s-core"         % Http4sVersion,
      "org.http4s"          %% "http4s-client"       % Http4sVersion,
      "org.http4s"          %% "http4s-server"       % Http4sVersion,
      "org.http4s"          %% "http4s-circe"        % Http4sVersion,
      "org.typelevel"       %% "log4cats-slf4j"      % Log4CatsVersion,
      "ch.qos.logback"       % "logback-classic"     % LogbackVersion           % Runtime,
      "org.scalameta"       %% "munit"               % MunitVersion             % Test,
      "org.typelevel"       %% "munit-cats-effect"   % MunitCatsEffectVersion   % Test,
      "com.disneystreaming" %% "weaver-cats"         % WeaverCatsVersion        % Test,
      "org.typelevel"       %% "cats-effect-testkit" % CatsEffectTestKitVersion % Test
    ),
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Wunused:all",
      "-Wvalue-discard",
      "-Werror",
      "-no-indent",
      "-explain"
    ),
    testFrameworks ++= List(
      new TestFramework("munit.Framework"),
      new TestFramework("weaver.framework.CatsEffect")
    ),
    assembly / assemblyJarName := "app.jar",
    assemblyMergeStrategy := {
      case PathList("META-INF", "MANIFEST.MF")  => MergeStrategy.discard
      case x if x.endsWith("module-info.class") => MergeStrategy.discard
      case x                                    => assemblyMergeStrategy.value(x)
    }
  )
