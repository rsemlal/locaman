package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

case class EntryTypeRef(id: String) extends ObjectRef {
  override val domain = "http://locaman"
  override val parents = Nil
  override val directory = "entry_type"
}

trait EntryType extends ObjectData[EntryTypeRef, HNil] {

  override def toHList = HNil
}