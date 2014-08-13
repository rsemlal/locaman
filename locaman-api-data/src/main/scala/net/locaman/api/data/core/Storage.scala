package net.locaman.api.data.core

trait Storage[TRef <: ObjectRef, TData <: ObjectData[TRef, _]] {
  def add(data: TData): Unit

  def delete(ref: TRef): Unit

  def get(ref: TRef): Option[TData]

  def all: Seq[TData]

}