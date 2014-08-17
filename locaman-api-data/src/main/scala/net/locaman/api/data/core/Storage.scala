package net.locaman.api.data.core

trait Storage[TRef <: ObjectRef, TData <: ObjectData[TRef, _]] {
  def add(data: TData): TRef

  def delete(ref: TRef): Unit

  def get(ref: TRef): Option[TData]

  def list(): Seq[IdentifiedObject[TRef, TData]]

  def count(): Long

}

trait QueryableStorageCompanion {
  type Query
  type QueryBuilder <: IQueryBuilder

  trait IQueryBuilder {
    def query: Query
  }
}

trait QueryableStorage[TData <: ObjectData[_, _]] {
  this: Storage[_, TData] =>
  val companion: QueryableStorageCompanion
  protected def newQueryBuilder: companion.QueryBuilder

  def query(query: companion.Query): Seq[TData]

  def count(query: companion.Query): Long
}