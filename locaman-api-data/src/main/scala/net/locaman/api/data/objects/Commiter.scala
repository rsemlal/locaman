package net.locaman.api.data.objects

import net.locaman.api.data.core.NoParentObjectRef
import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

object Commiter {
  final val directory = "commiter"

  case class Ref(id: String) extends ObjectRef with LocamanObjectRef with NoParentObjectRef {
    override final val directory = Commiter.directory
  }

  case class Data(ref: Ref) extends Commiter
}

trait Commiter extends ObjectData[Commiter.Ref, HNil] {

  override final def toHList = HNil
}