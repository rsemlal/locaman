package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless._

case class CommitRef(valueRef: AttributeValueRef, sequenceNr: Int) extends ObjectRef {
  override val domain = "http://locaman"
  override val parents = Seq(valueRef)
  override val directory = "commit"
  override val id = String.valueOf(sequenceNr)
}

object Commit {

  object CommitType extends Enumeration {
    type CommitType = Value
    val Set, Unset = Value
  }

}

trait Commit extends ObjectData[CommitRef, Commit.CommitType.CommitType :: HNil] {
  def commitType: Commit.CommitType.CommitType

  override def toHList = commitType :: HNil
}