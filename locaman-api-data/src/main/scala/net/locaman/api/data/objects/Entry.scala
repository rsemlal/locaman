package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

case class EntryRef(entryTypeRef: EntryTypeRef, id: String) extends ObjectRef {
  override val domain = "http://locaman"
  override val parents = Seq(entryTypeRef)
  override val directory = "entry_type"
}

trait Entry extends ObjectData[EntryRef, HNil] {

  override def toHList = HNil
}