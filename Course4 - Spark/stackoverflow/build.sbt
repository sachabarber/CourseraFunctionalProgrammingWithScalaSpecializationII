name := course.value + "-" + assignment.value

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation")

courseId := "GgMUTQlcEeeUowqmzGUjkg"

resolvers += Resolver.sonatypeRepo("releases")

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies ++= assignmentsMap.value.values.flatMap(_.dependencies).toSeq

// include the common dir
commonSourcePackages += "common"

assignmentsMap := {
  val depsSpark = Seq(
    "org.apache.spark" %% "spark-core" % "2.0.0"
  )
  Map(
    "example" -> Assignment(
      packageName = "example",
      key = "9W3VuiJREeaFaw43_UrNUw",
      itemId = "I6L8m",
      partId = "vsJoj",
      maxScore = 10d,
      dependencies = Seq(),
      options = Map("Xmx"->"1540m", "grader-memory"->"2048")),
    "wikipedia" -> Assignment(
      packageName = "wikipedia",
      key = "EH8wby4kEeawURILfHIqjw",
      itemId = "QcWcs",
      partId = "5komc",
      maxScore = 10d,
      styleScoreRatio = 0.0,
      dependencies = depsSpark,
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2")),
    "stackoverflow" -> Assignment(
      packageName = "stackoverflow",
      key = "JH0diQlcEeer0A6dcha8Vg",
      itemId = "Re42P",
      partId = "dKQkB",
      maxScore = 10d,
      styleScoreRatio = 0.0,
      dependencies = depsSpark,
      options = Map("Xmx"->"800m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2")),
    "timeusage" -> Assignment(
      packageName = "timeusage",
      key = "mVk0fgQ0EeeGZQrYVAT1jg",
      itemId = "T19Ec",
      partId = "y8PO8",
      maxScore = 10d,
      styleScoreRatio = 0.0,
      dependencies = depsSpark :+ ("org.apache.spark" %% "spark-sql" % "2.0.0"),
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2"))
  )
}

