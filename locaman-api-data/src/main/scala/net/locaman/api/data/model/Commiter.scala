package net.locaman.api.data.model

import net.locaman.api.data.ifaces.IdentifiableObject
import net.locaman.api.data.ifaces.IdentifiableObjectCompanion

object Commiter extends IdentifiableObjectCompanion[Commiter] {
  final type Id = String
  final type Values = Unit
}

trait Commiter extends IdentifiableObject {
  protected final override val companion = Commiter
  protected[data] final override def values = ()
}