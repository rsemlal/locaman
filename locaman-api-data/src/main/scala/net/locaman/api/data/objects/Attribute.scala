package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{ :: => :: }
import shapeless.HNil
import net.locaman.api.valuetype.ValueType

object Attribute {

  case class Ref(id: String) extends ObjectRef {
    override val domain = "http://locaman"
    override val parents = Nil
    override val directory = "attribute"
  }
}

trait Attribute extends ObjectData[Attribute.Ref, ValueType :: HNil] {
  def valueType: ValueType

  override def toHList = valueType :: HNil
}