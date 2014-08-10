package net.locaman.api.data.ifaces

trait IdentifiableObjectCompanion[T <: IdentifiableObject] {
  type Id
  type Values

  def isSameId(a: T, b: T) = a.id == b.id
  def isSameValues(a: T, b: T) = a.values == b.values

  object HasId {
    def unapply(o: T) = Some(o.id)
  }
  object HasValues {
    def unapply(o: T) = Some(o.values)
  }
}

trait IdentifiableObject {
  protected val companion: IdentifiableObjectCompanion[_]
  def id: companion.Id
  protected[data] def values: companion.Values
}