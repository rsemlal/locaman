package net.locaman.api.data.model

import net.locaman.api.data.ifaces.IdentifiableObject
import net.locaman.api.data.ifaces.IdentifiableObjectCompanion

object Entry extends IdentifiableObjectCompanion[Entry] {
  final type Id = String
  final type Values = EntryType
}

trait Entry extends IdentifiableObject {
  protected final override val companion = Entry
  protected[data] final override def values = (this.entryType)

  def entryType: EntryType
}