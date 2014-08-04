import sbt._
import sbt.Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin._

object LocamanMainBuild extends Build {
  lazy val root = (project in file("."))
    .aggregate(common, data)

  lazy val common = (project in file("locaman-common"))
    .settings(CommonSettings.all: _*)

  lazy val data = (project in file("locaman-data"))
    .settings(CommonSettings.all: _*)
    .dependsOn(common)

  object CommonSettings {
    lazy val all = Project.defaultSettings ++ _eclipseSettings ++ Seq(
      _scalaVersion,
      _organization,
      _version,
      _scalacOptions)

    lazy val _scalaVersion = (scalaVersion := "2.11.2")
    lazy val _organization = (organization := "net.locaman")
    lazy val _version = (version := "0.1")
    lazy val _scalacOptions = (scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked"))
    lazy val _eclipseSettings = Seq(
      EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource,
      EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17),
      EclipseKeys.withSource := true,
      EclipseKeys.withBundledScalaContainers := false)
  }
}
