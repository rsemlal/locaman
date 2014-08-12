package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

object Commiter {
  final val directory = "commiter"

  case class Ref(id: String) extends LocamanObjectRef {
    override val parents = Nil
    override val directory = Commiter.directory
  }
}

trait Commiter extends ObjectData[Commiter.Ref, HNil] {

  override def toHList = HNil
}