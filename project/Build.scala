import sbt._
import sbt.Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin._

object LocamanMainBuild extends Build {
  lazy val root = (project in file("."))
    .aggregate(apiData, apiValueType)

  lazy val apiValueType = ProjectSettings.defProject("api-valuetype")
  lazy val apiData = ProjectSettings.defProject("api-data") dependsOn(apiValueType)
}
