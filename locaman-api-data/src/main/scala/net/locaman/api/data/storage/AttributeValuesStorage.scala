package net.locaman.api.data.storage

import net.locaman.api.data.core.QueryableStorage
import net.locaman.api.data.core.QueryableStorageCompanion
import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Attribute
import net.locaman.api.data.objects.AttributeValue
import net.locaman.api.data.objects.Entry

object AttributeValuesStorage extends QueryableStorageCompanion {
  case class Query(entry: Option[Entry.Ref], attribute: Option[Attribute.Ref])

  class QueryBuilder(val query: Query) extends IQueryBuilder {
    def entry(v: Entry.Ref) = new QueryBuilder(query.copy(entry = Some(v)))
    def attribute(v: Attribute.Ref) = new QueryBuilder(query.copy(attribute = Some(v)))
  }
}

trait AttributeValuesStorage extends Storage[AttributeValue.Ref, AttributeValue] with QueryableStorage[AttributeValue] {
  import AttributeValuesStorage._

  final val companion = AttributeValuesStorage
  protected final def newQueryBuilder = new QueryBuilder(Query(None, None))
}