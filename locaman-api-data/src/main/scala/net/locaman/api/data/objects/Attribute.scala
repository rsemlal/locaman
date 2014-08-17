package net.locaman.api.data.objects

import net.locaman.api.data.core.NoParentObjectRef
import net.locaman.api.data.core.ObjectData
import net.locaman.api.valuetype.ValueType
import shapeless.{ :: => :: }
import shapeless.HNil
import net.locaman.api.data.core.ObjectRef
import net.locaman.api.data.core.NoParentObjectRef

object Attribute {
  final val directory = "attribute"

  case class Ref(id: String) extends ObjectRef with LocamanObjectRef with NoParentObjectRef {
    override final val directory = Attribute.directory
  }

  case class Data(id: String, valueType: ValueType) extends ObjectData[Attribute.Ref, String :: ValueType :: HNil] {

    override final def toHList = id :: valueType :: HNil
  }
}

trait Attribute {
}