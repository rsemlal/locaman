package net.locaman.api.valuetype

object ValueType {
  /**
   * Extracts the fields {{{id}}} and {{{isList}}} from [[net.locaman.api.valuetype.ValueType]].
   */
  def unapply(o: ValueType) = {
    Some((o.id, o.isList))
  }

  object Atomic {
    def apply(id: String) = AtomicValueType(id)

    def unapply(o: ValueType) = o match {
      case e: AtomicValueType => Some(o.id)
      case _ => None
    }
  }

  object List {
    def apply(atomicId: String) = ListValueType(Atomic(atomicId))
    def apply(atomic: AtomicValueType) = ListValueType(atomic)

    def unapply(o: ValueType) = o match {
      case e: ListValueType => Some(o.atomicType)
      case _ => None
    }
  }
}

sealed trait ValueType {
  def id: String
  def isList: Boolean

  def listType: ListValueType
  def atomicType: AtomicValueType
}

case class AtomicValueType(id: String) extends ValueType {
  override def isList = false

  override def listType = new ListValueType(this)
  override def atomicType = this
}

case class ListValueType(atomicType: AtomicValueType) extends ValueType {
  override def id = atomicType.id + ".list"

  override def isList = true

  override def listType = this
}