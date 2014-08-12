package net.locaman.api.data.objects

import net.locaman.api.data.core.NoParentObjectRef
import net.locaman.api.data.core.ObjectData
import shapeless.HNil
import net.locaman.api.data.core.ObjectRef

object EntryType {
  final val directory = "entry_type"

  case class Ref(id: String) extends ObjectRef with LocamanObjectRef with NoParentObjectRef {
    override final val directory = EntryType.directory
  }

  case class Data(ref: Ref) extends EntryType
}

trait EntryType extends ObjectData[EntryType.Ref, HNil] {

  override final def toHList = HNil
}