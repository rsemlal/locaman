package net.locaman.api.data.core

case class IdentifiedObject[TRef <: ObjectRef, TData <: ObjectData[TRef, _]](ref: TRef, data: TData)