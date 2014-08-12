package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{:: => ::}
import shapeless.HNil
import net.locaman.api.valuetype.ValueType
import akka.util.ByteString

case class AttributeValueRef(entryRef: EntryRef, attributeRef: AttributeRef, id: String) extends ObjectRef {
  override val domain = "http://locaman"
  override val parents = Seq(entryRef, attributeRef)
  override val directory = "attribute_value"
}

trait AttributeValue extends ObjectData[AttributeValueRef, ByteString :: HNil] {
  def value: ByteString

  override def toHList = value :: HNil
}