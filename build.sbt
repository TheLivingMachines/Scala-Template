name := "Scala-Template"

version := "0.1"

scalaVersion := "2.11.8"

// scala test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"

// configuration
libraryDependencies += "com.typesafe" % "config" % "1.2.1"

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10"

// akka actor and akka kafka streaming packages
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.5.8",
  "com.typesafe.akka" %% "akka-stream-kafka" % "0.20"
)
// kafka libraries
libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "1.0.0",
  "org.apache.kafka" % "kafka-clients" % "1.0.0"
)

