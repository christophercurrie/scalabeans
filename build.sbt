name := "scalabeans"

organization := "com.fasterxml.jackson.module"

version := "0.4-SNAPSHOT"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

libraryDependencies ++= Seq(
  "com.thoughtworks.paranamer" % "paranamer" % "2.3",
  "com.google.guava" % "guava" % "13.0.1",
  "com.dadrox" %% "sbt-junit" % "0.1" % "test"
)

libraryDependencies <++= (scalaVersion, scalaBinaryVersion) { (ver, binVer) => binVer match {
  case "2.10" => Seq("org.scala-lang" % "scala-reflect" % ver)
  case _ => Nil
} }

unmanagedSourceDirectories in Compile <+= (scalaBinaryVersion, baseDirectory) { (ver, dir) => ver match {
  case "2.9.1" | "2.9.2" => dir / "src/main/scala29"
  case "2.10" => dir / "src/main/scala210"
} }

testFrameworks += new TestFramework("com.dadrox.sbt.junit.JunitFramework")
