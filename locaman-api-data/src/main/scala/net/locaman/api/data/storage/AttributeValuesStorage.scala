package net.locaman.api.data.storage

import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.AttributeValue
import net.locaman.api.data.objects.Entry
import net.locaman.api.data.objects.Attribute

trait AttributeValuesStorage extends Storage[AttributeValue.Ref, AttributeValue] {
  def list(entry: Option[Entry.Ref] = None, attribute: Option[Attribute.Ref] = None): Seq[AttributeValue]
}