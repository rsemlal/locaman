package net.locaman.api.data.model

import net.locaman.api.data.ifaces.IdentifiableObject
import net.locaman.api.data.ifaces.IdentifiableObjectCompanion
import akka.util.ByteString

object AttributeValue extends IdentifiableObjectCompanion[AttributeValue] {
   final type Id = Long
   final type Values = (Entry, Attribute, ByteString)
}

trait AttributeValue extends IdentifiableObject {
  protected final override val companion = AttributeValue
  protected[data] final override def values = (this.entry, this.attribute, this.value)

  def entry: Entry
  def attribute: Attribute
  def value: ByteString
}