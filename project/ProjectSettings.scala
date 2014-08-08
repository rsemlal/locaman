import sbt._
import sbt.Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin._

/**
 * @author rsemlal
 */
object ProjectSettings {

  def defProject(name: String) = {
    Project(name, file(name), settings = ProjectSettings.defaults)
  }

  private lazy val defaults = Defaults.coreDefaultSettings ++ Seq(
    organization := Constants.organisation,
    version := Constants.version,

    scalaVersion := Constants.scalaVersion,

    scalacOptions ++= Constants.compilerOptions,

    EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.withName(Constants.javaVersion)),
    EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Managed + EclipseCreateSrc.Resource,
    EclipseKeys.withSource := true,
    EclipseKeys.withBundledScalaContainers := false)
}