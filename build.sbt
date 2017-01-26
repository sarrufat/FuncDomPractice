lazy val commonSettings = Seq(
  version := "0.0.1",
  resolvers ++= Seq(
      Resolver.mavenLocal
    , Resolver.sonatypeRepo("releases")
    , Resolver.sonatypeRepo("snapshots")
    , "Bintray " at "https://dl.bintray.com/projectseptemberinc/maven"
  ),
  scalaVersion := "2.11.8",
  licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
 // addCompilerPlugin("org.spire-math" %% "kind-projector"  % "0.8.0"),
  libraryDependencies ++= Seq(
     // "org.scalaz"                   %% "scalaz-core"                   % "7.2.4",
     // "org.scalaz"                   %% "scalaz-concurrent"             % "7.2.4",
     "org.typelevel" %% "cats" % "0.9.0",
      "joda-time"                     % "joda-time"                     % "2.9.1",
      "org.joda"                      % "joda-convert"                  % "1.8.1",
      "io.spray"                     %% "spray-json"                    % "1.3.2",
      "com.typesafe.akka"            %% "akka-actor"                    % "2.4.8",
      "com.typesafe.akka"            %% "akka-persistence"              % "2.4.8",
      "com.typesafe.akka"            %% "akka-stream"                   % "2.4.8",
      "com.typesafe.scala-logging"   %% "scala-logging-slf4j"           % "2.1.2",
      "com.typesafe.slick"           %% "slick"                         % "3.0.0",
      "ch.qos.logback"                % "logback-classic"               % "1.1.3",
      "org.scalacheck" %% "scalacheck" % "1.13.4" % "test", 
      "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
    )
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "FuncDomPractice",
    scalacOptions ++= Seq(
      "-feature",
      "-unchecked",
      "-language:higherKinds",
      "-language:postfixOps",
      "-deprecation"
    )
  )

