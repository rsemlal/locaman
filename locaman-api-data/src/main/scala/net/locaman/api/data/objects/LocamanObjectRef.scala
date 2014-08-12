package net.locaman.api.data.objects

import net.locaman.api.data.core.ObjectRef

object LocamanObjectRef {
  final val domain = "http://locaman"
}

trait LocamanObjectRef {
  this: ObjectRef =>
  override final val domain = LocamanObjectRef.domain
}