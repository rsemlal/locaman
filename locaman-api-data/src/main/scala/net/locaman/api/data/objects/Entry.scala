package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import shapeless.HNil

object Entry {
  final val directory = "entry"

  case class Ref(entryTypeRef: EntryType.Ref, id: String) extends LocamanObjectRef {
    override val parents = Seq(entryTypeRef)
    override val directory = Entry.directory
  }
}

trait Entry extends ObjectData[Entry.Ref, HNil] {

  override def toHList = HNil
}