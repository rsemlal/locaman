package net.locaman.api.data.model

import net.locaman.api.data.ifaces.IdentifiableObject
import net.locaman.api.data.ifaces.IdentifiableObjectCompanion
import net.locaman.api.valuetype.ValueType

object Attribute extends IdentifiableObjectCompanion[Attribute] {
  final type Id = String
  final type Values = (ValueType)
}

trait Attribute extends IdentifiableObject {
  protected final override val companion = Attribute
  protected[data] final override def values = (this.attributeType)

  def attributeType: ValueType
}