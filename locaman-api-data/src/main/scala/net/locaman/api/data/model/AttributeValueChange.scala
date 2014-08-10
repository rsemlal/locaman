package net.locaman.api.data.model

import net.locaman.api.data.ifaces.IdentifiableObjectCompanion
import net.locaman.api.data.ifaces.IdentifiableObject
import org.joda.time.Instant

object AttributeValueChange extends IdentifiableObjectCompanion[AttributeValueChange] {
  final type Id = Long
  final type Values = (ChangeType.Value, AttributeValue, Commiter, Instant)

  object ChangeType extends Enumeration {
    type AttributeValueChangeType = Value
    val Set, Unset = Value
  }
}

trait AttributeValueChange extends IdentifiableObject {
  protected final override val companion = AttributeValueChange
  protected[data] final override def values = (this.changeType, this.attributeValue, this.commiter, this.timestamp)


  def changeType: AttributeValueChange.ChangeType.Value
  def attributeValue: AttributeValue
  def commiter: Commiter
  def timestamp: Instant
}