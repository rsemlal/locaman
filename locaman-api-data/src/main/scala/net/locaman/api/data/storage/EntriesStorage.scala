package net.locaman.api.data.storage

import net.locaman.api.data.core.QueryableStorage
import net.locaman.api.data.core.QueryableStorageCompanion
import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Entry
import net.locaman.api.data.objects.EntryType

object EntriesStorage extends QueryableStorageCompanion {
  case class Query(entryType: Option[EntryType.Ref])

  class QueryBuilder(val query: Query) extends IQueryBuilder {
    def valueType(v: EntryType.Ref) = new QueryBuilder(query.copy(entryType = Some(v)))
  }
}

trait EntriesStorage extends Storage[Entry.Ref, Entry.Data] with QueryableStorage[Entry.Data] {
  import EntriesStorage._
  final val companion = EntriesStorage
  protected final def newQueryBuilder = new QueryBuilder(Query(None))
}