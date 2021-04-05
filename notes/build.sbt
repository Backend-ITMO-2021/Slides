name := "notes"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "com.lihaoyi" %% "requests" % "0.6.5"
libraryDependencies += "org.kohsuke" % "github-api" % "1.125"

javacOptions ++= Seq("-source", "15", "-target", "15", "-Xlint")

initialize := {
  val _ = initialize.value
  val javaVersion = sys.props("java.specification.version")
  if (javaVersion != "15")
    sys.error("Java 15 is required for this project. Found " + javaVersion + " instead")
}