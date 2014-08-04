name := "sbt-project"

version := "0.1"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked")

EclipseKeys.createSrc := EclipseCreateSrc.Default

EclipseKeys.withSource := true

EclipseKeys.withBundledScalaContainers := false