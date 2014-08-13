package net.locaman.api.data.core

trait Storage[TRef <: ObjectRef, TData <: ObjectData[TRef, _]] {
  def add(data: TData): Unit

  def delete(ref: TRef): Unit

  def get(ref: TRef): Option[TData]

  def all: Seq[TData]

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

  def query(f: companion.QueryBuilder => companion.QueryBuilder): Seq[TData] = {
    val queryBuilder0 = newQueryBuilder
    val _query = f(queryBuilder0).query
    query(_query)
  }
}