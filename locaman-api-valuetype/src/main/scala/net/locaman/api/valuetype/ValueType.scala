package net.locaman.api.valuetype

case class ValueType(id: String, isList: Boolean) {
  def listType = if(isList) this else ValueType(id, isList = true)
  def atomicType = if(!isList) this else ValueType(id, isList = false)
}