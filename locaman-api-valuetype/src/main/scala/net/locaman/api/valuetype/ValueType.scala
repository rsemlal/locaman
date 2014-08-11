package net.locaman.api.valuetype

sealed trait ValueType {
  def id: String
  def isList: Boolean

  def listType: ListValueType
  def atomicType: AtomicValueType
}

case class ListValueType(atomicType: AtomicValueType) extends ValueType {
  def id = atomicType.id + ".list"

  def isList = true

  def listType = this
}

case class AtomicValueType(id: String) extends ValueType {
  def isList = false

  def listType = new ListValueType(this)
  def atomicType = this
}