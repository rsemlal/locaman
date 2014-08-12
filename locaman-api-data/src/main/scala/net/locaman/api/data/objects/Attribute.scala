package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.valuetype.ValueType
import shapeless.{ :: => :: }
import shapeless.HNil

object Attribute {
  final val directory = "attribute"

  case class Ref(id: String) extends LocamanObjectRef {
    override val parents = Nil
    override val directory = Attribute.directory
  }
}

trait Attribute extends ObjectData[Attribute.Ref, ValueType :: HNil] {
  def valueType: ValueType

  override def toHList = valueType :: HNil
}