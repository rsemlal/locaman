package net.locaman.api.data.objects

import akka.util.ByteString
import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{ :: => :: }
import shapeless.HNil

object AttributeValue {
  final val directory = "attribute_value"

  case class Ref(entryRef: Entry.Ref, attributeRef: Attribute.Ref, id: String) extends ObjectRef with LocamanObjectRef {
    override final val parents = Seq(entryRef, attributeRef)
    override final val directory = AttributeValue.directory
  }

  case class Data(ref: Ref, value: ByteString) extends AttributeValue
}

trait AttributeValue extends ObjectData[AttributeValue.Ref, ByteString :: HNil] {
  def value: ByteString

  override final def toHList = value :: HNil
}