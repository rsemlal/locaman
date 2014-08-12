package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

object Entry {
  final val directory = "entry"

  case class Ref(entryTypeRef: EntryType.Ref, id: String) extends ObjectRef with LocamanObjectRef {
    override final val parents = Seq(entryTypeRef)
    override final val directory = Entry.directory
  }

  case class Data(ref: Ref) extends Entry
}

trait Entry extends ObjectData[Entry.Ref, HNil] {

  override final def toHList = HNil
}