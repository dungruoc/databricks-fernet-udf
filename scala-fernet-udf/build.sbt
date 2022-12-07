name := "decryptUDF"
version := "1.0"

scalaVersion := "2.12.17"

libraryDependencies += "org.apache.hive" % "hive-exec" % "3.1.2"
libraryDependencies += "com.macasaet.fernet" % "fernet-java8" % "1.5.0"

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}