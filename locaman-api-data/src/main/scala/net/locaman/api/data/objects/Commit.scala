package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{ :: => :: }
import shapeless.HNil
import org.joda.time.Instant

object Commit {
  final val directory = "commit"

  case class Ref(valueRef: AttributeValue.Ref, sequenceNr: Int) extends ObjectRef with LocamanObjectRef {
    override final val parents = Seq(valueRef)
    override final val directory = Commit.directory
    override final val id = String.valueOf(sequenceNr)
  }

  case class Data(
    valueRef: AttributeValue.Ref,
    commitType: CommitType.CommitType,
    commiter: Commiter.Ref,
    timestamp: Instant) extends ObjectData[Commit.Ref, AttributeValue.Ref :: Commit.CommitType.CommitType :: Commiter.Ref :: Instant :: HNil] {

    override final def toHList = valueRef :: commitType :: commiter :: timestamp :: HNil
  }

  object CommitType extends Enumeration {
    type CommitType = Value
    val Set, Unset = Value
  }
}

trait Commit {
}