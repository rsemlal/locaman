package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{ :: => :: }
import shapeless.HNil
import org.joda.time.Instant

object Commit {
  final val directory = "commit"

  object CommitType extends Enumeration {
    type CommitType = Value
    val Set, Unset = Value
  }

  case class Ref(valueRef: AttributeValue.Ref, sequenceNr: Int) extends LocamanObjectRef {
    override final val parents = Seq(valueRef)
    override final val directory = Commit.directory
    override final val id = String.valueOf(sequenceNr)
  }

  case class Data(ref: Ref, commitType: CommitType.CommitType, commiter: Commiter.Ref, timestamp: Instant) extends Commit
}

trait Commit extends ObjectData[Commit.Ref, Commit.CommitType.CommitType :: Commiter.Ref :: Instant :: HNil] {
  def commitType: Commit.CommitType.CommitType
  def commiter: Commiter.Ref
  def timestamp: Instant

  override final def toHList = commitType :: commiter :: timestamp :: HNil
}