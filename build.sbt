name := "play-java"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
  ,"junit" % "junit" % "4.12"
  ,"junit" % "junit-dep" % "4.11"
  ,"com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.5.3"
  //,"joda-time" % "joda-time" % "2.8"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
