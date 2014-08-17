package net.locaman.api.data.core

import shapeless.HList

object ObjectData {
  def unapply[A <: ObjectRef, B <: HList](o: ObjectData[A, B]) = Some(o.toHList)
}

trait ObjectData[TRef <: ObjectRef, TValues <: HList] {
  def toHList: TValues
}