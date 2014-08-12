package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

object Entry {
  case class Ref(entryTypeRef: EntryType.Ref, id: String) extends ObjectRef {
    override val domain = "http://locaman"
    override val parents = Seq(entryTypeRef)
    override val directory = "entry_type"
  }
}

trait Entry extends ObjectData[Entry.Ref, HNil] {

  override def toHList = HNil
}