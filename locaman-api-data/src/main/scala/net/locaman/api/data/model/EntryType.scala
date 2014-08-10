package net.locaman.api.data.model

import net.locaman.api.data.ifaces.IdentifiableObject
import net.locaman.api.data.ifaces.IdentifiableObjectCompanion

object EntryType extends IdentifiableObjectCompanion[EntryType] {
  final type Id = String
  final type Values = Unit
}

trait EntryType extends IdentifiableObject {
  protected final override val companion = EntryType
  protected[data] final override def values = ()
}