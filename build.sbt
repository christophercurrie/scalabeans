name := "scalabeans"

organization := "com.fasterxml.jackson.module"

version := "0.4-SNAPSHOT"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0-RC5")

libraryDependencies ++= Seq(
  "com.thoughtworks.paranamer" % "paranamer" % "2.3",
  "com.google.guava" % "guava" % "13.0.1"
)

libraryDependencies <++= scalaVersion { (ver) => ver match {
  case "2.10.0-RC5" => Seq("org.scala-lang" % "scala-reflect" % ver)
  case _ => Nil
} }

unmanagedSourceDirectories in Compile <+= (scalaVersion, baseDirectory) { (ver, dir) => ver match {
  case "2.9.1" | "2.9.2" => dir / "src/main/scala29"
  case "2.10.0-RC5" => dir / "src/main/scala210"
} }

