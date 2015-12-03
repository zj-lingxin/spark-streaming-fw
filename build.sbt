name := "spark-streaming-fw"

version := "1.0"

scalaVersion := "2.10.4"

/*
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"*/

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.5.2"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.10" % "1.5.2"
    