package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import shapeless.HNil

object EntryType {
  final val directory = "entry_type"

  case class Ref(id: String) extends LocamanObjectRef {
    override val parents = Nil
    override val directory = EntryType.directory
  }
}

trait EntryType extends ObjectData[EntryType.Ref, HNil] {

  override def toHList = HNil
}