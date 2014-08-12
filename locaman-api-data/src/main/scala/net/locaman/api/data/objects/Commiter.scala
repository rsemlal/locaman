package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

object Commiter {
  case class Ref(id: String) extends ObjectRef {
    override val domain = "http://locaman"
    override val parents = Nil
    override val directory = "commiter"
  }
}

trait Commiter extends ObjectData[Commiter.Ref, HNil] {

  override def toHList = HNil
}