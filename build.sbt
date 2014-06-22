import _root_.sbt.Keys._

name := "ecrf"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.typesafe" %% "play-plugins-mailer" % "2.2.0",
  "com.amazonaws" % "aws-java-sdk" % "1.7.3",
  "com.google.apis" % "google-api-services-storage" % "v1beta2-rev39-1.17.0-rc",
  //"com.jolbox" % "bonecp" % "0.8.1-SNAPSHOT",
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "org.mindrot" % "jbcrypt" % "0.3m",
  "joda-time" % "joda-time" % "2.0",
  "net.sf.opencsv" % "opencsv" % "2.3"
)

resolvers += "Sonatype OSS Snapshots Repository" at "http://oss.sonatype.org/content/groups/public"


play.Project.playJavaSettings
