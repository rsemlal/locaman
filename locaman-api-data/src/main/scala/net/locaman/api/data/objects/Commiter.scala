package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.HNil

case class CommiterRef(id: String) extends ObjectRef {
  override val domain = "http://locaman"
  override val parents = Nil
  override val directory = "commiter"
}

trait Commiter extends ObjectData[CommiterRef, HNil] {

  override def toHList = HNil
}