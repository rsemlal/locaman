package net.locaman.api.data.storage

import net.locaman.api.data.core.QueryableStorage
import net.locaman.api.data.core.QueryableStorageCompanion
import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Attribute
import net.locaman.api.valuetype.ValueType

object AttributesStorage extends QueryableStorageCompanion {
  case class Query(valueType: Option[ValueType])

  class QueryBuilder(val query: Query) extends IQueryBuilder {
    def valueType(v: ValueType) = new QueryBuilder(query.copy(valueType = Some(v)))
  }
}

trait AttributesStorage extends Storage[Attribute.Ref, Attribute.Data] with QueryableStorage[Attribute.Data] {
  import AttributesStorage._

  final val companion = AttributesStorage
  protected final def newQueryBuilder = new QueryBuilder(Query(None))
}