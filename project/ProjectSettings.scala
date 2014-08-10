import sbt._
import sbt.Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin._
import com.typesafe.sbt.SbtGit._

/**
 * @author rsemlal
 */
object ProjectSettings {

  def defProject(name: String) = {
    val fullName = Constants.namePrefix + name
    Project(fullName, file(fullName), settings = ProjectSettings.defaults)
  }

  private lazy val defaults =
    Defaults.coreDefaultSettings ++
      compilationSettings ++
      eclipseSettings ++
      gitSettings

  private lazy val compilationSettings = Seq(
    organization := Constants.organisation,
    scalaVersion := Constants.scalaVersion,
    scalacOptions ++= Constants.compilerOptions)

  private lazy val eclipseSettings = Seq(
    EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.withName(Constants.javaVersion)),
    EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Managed + EclipseCreateSrc.Resource,
    EclipseKeys.withSource := true,
    EclipseKeys.withBundledScalaContainers := false)

  private lazy val gitSettings = versionWithGit ++ Seq(
    useJGit,
    git.baseVersion := Constants.initialVersion)

}