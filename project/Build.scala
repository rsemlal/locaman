import sbt._
import sbt.Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin._

object LocamanMainBuild extends Build {
  lazy val root = (project in file("."))
    .aggregate(common, data)

  lazy val common = ProjectSettings.defProject("common")
  lazy val data = ProjectSettings.defProject("data")
    .dependsOn(common)
}
