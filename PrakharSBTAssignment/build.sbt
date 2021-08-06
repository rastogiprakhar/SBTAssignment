name := "PrakharSBTAssignment"

version := "1.4.4"

scalaVersion := "2.12.12"


//All dependencies used in the project
lazy val Dependencies=
  new{
    val scalactic="org.scalactic" %% "scalactic" % "3.3.0-SNAP3"
    val scalaz= "org.scalaz" %% "scalaz-core" % "7.3.4"
    val mockito="org.mockito" %% "mockito-scala" % "1.16.37"
    val scalaTest="org.scalatest" %% "scalatest" % "3.3.0-SNAP3"
    val akkaActor="com.typesafe.akka" %% "akka-actor" % "2.6.15"
    val akkaStream="com.typesafe.akka" %% "akka-stream" % "2.6.15"
    val akkaHttp="com.typesafe.akka" %% "akka-http" % "10.2.4"
    val json4s="org.json4s" %% "json4s-native" % "4.0.3"
    val akkaStreamTestkit= "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.15"
    val akkaHttpTestkit="com.typesafe.akka" %% "akka-http-testkit" % "10.2.5"
    val akkaTestkit="com.typesafe.akka" %% "akka-testkit" % "2.6.15"
  }


//Adding dependencies into "common" module
lazy val common = (project in file("common"))
  .settings(
    name := "common",
    libraryDependencies ++= Seq(
      Dependencies.scalaz,
      Dependencies.scalactic,
      Dependencies.mockito % "Test",
      Dependencies.scalaTest % "Test"
    )
  )

//Adding dependencies into "rest" module
lazy val rest = (project in file("rest"))
  .settings(
    name := "rest",
    libraryDependencies ++= Seq(
      Dependencies.akkaHttp,
      Dependencies.akkaStream,
      Dependencies.akkaActor,
      Dependencies.json4s,
      Dependencies.akkaStreamTestkit % "Test",
      Dependencies.akkaHttpTestkit % "Test",
      Dependencies.akkaTestkit % "test"
    )
  )


lazy val root = (project in file(".")).aggregate(common, rest)