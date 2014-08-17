package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{:: => :: }
import shapeless.HNil

object Entry {
  final val directory = "entry"

  case class Ref(entryTypeRef: EntryType.Ref, id: String) extends ObjectRef with LocamanObjectRef {
    override final val parents = Seq(entryTypeRef)
    override final val directory = Entry.directory
  }

  case class Data(entryTypeRef: EntryType.Ref) extends Entry
}

trait Entry extends ObjectData[Entry.Ref, EntryType.Ref :: HNil] {

  def entryTypeRef: EntryType.Ref

  override final def toHList = entryTypeRef :: HNil
}