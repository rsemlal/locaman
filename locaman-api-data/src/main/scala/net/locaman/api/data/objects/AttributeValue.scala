package net.locaman.api.data.objects

import akka.util.ByteString
import net.locaman.api.data.core.ObjectData
import net.locaman.api.data.core.ObjectRef
import shapeless.{ :: => :: }
import shapeless.HNil

object AttributeValue {
  final val directory = "attribute_value"

  case class Ref(entryRef: Entry.Ref, attributeRef: Attribute.Ref, sequenceNr: Long) extends ObjectRef with LocamanObjectRef {
    override final val parents = Seq(entryRef, attributeRef)
    override final val directory = AttributeValue.directory
    override final val id = String.valueOf(sequenceNr)
  }

  case class Data(entryRef: Entry.Ref, attributeRef: Attribute.Ref, value: ByteString) extends ObjectData[AttributeValue.Ref, Entry.Ref :: Attribute.Ref :: ByteString :: HNil] {

    override final def toHList = entryRef :: attributeRef :: value :: HNil
  }
}

trait AttributeValue