package net.locaman.api.data.objects

import akka.util.ByteString
import net.locaman.api.data.core.ObjectData
import shapeless.{ :: => :: }
import shapeless.HNil

object AttributeValue {
  final val directory = "attribute_value"

  case class Ref(entryRef: Entry.Ref, attributeRef: Attribute.Ref, id: String) extends LocamanObjectRef {
    override val parents = Seq(entryRef, attributeRef)
    override val directory = AttributeValue.directory
  }
}

trait AttributeValue extends ObjectData[AttributeValue.Ref, ByteString :: HNil] {
  def value: ByteString

  override def toHList = value :: HNil
}