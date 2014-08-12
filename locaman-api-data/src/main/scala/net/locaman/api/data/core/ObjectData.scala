package net.locaman.api.data.core

import shapeless.HList

trait ObjectData[TRef <: ObjectRef, TValues <: HList] {
  def ref: ObjectRef
  def toHList: TValues
}