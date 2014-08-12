package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{ :: => :: }
import shapeless.HNil
import org.joda.time.Instant

object Commit {
  final val directory = "commit"

  case class Ref(valueRef: AttributeValue.Ref, sequenceNr: Int) extends LocamanObjectRef {
    override val parents = Seq(valueRef)
    override val directory = Commit.directory
    override val id = String.valueOf(sequenceNr)
  }

  object CommitType extends Enumeration {
    type CommitType = Value
    val Set, Unset = Value
  }
}

trait Commit extends ObjectData[Commit.Ref, Commit.CommitType.CommitType :: Commiter.Ref :: Instant :: HNil] {
  def commitType: Commit.CommitType.CommitType
  def commiter: Commiter.Ref
  def timestamp: Instant

  override def toHList = commitType :: commiter :: timestamp :: HNil
}