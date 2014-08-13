package net.locaman.api.data.storage

import net.locaman.api.data.objects.Attribute
import net.locaman.api.data.core.Storage
import net.locaman.api.valuetype.ValueType

trait AttributesStorage extends Storage[Attribute.Ref, Attribute] {
  def list(valueType: ValueType): Seq[Attribute]
}