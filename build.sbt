
name := "monix"

val vAkkaHttp = "10.0.7"

version := "0.1"

scalaVersion := "2.12.6"

val scalaLogging = "3.5.0"



libraryDependencies += "io.monix" %% "monix" % "2.3.3"

libraryDependencies +="com.typesafe.akka" %% "akka-http" % vAkkaHttp
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws-standalone" % "2.0.0-M3"

libraryDependencies += "com.typesafe.play" %% "play-ws" % "2.7.0-M3"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % scalaLogging
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

