package net.locaman.api.data.storage

import org.joda.time.Instant

import net.locaman.api.data.core.QueryableStorage
import net.locaman.api.data.core.QueryableStorageCompanion
import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Attribute
import net.locaman.api.data.objects.Commit
import net.locaman.api.data.objects.Commiter
import net.locaman.api.data.objects.Entry

object CommitsStorage extends QueryableStorageCompanion {
  case class Query(
    entry: Option[Entry.Ref],
    attribute: Option[Attribute.Ref],
    commitType: Option[Commit.CommitType.CommitType],
    commiter: Option[Commiter.Ref],
    timestamp: Option[Instant])

  class QueryBuilder(val query: Query) extends IQueryBuilder {
    def entry(v: Entry.Ref) = new QueryBuilder(query.copy(entry = Some(v)))
    def attribute(v: Attribute.Ref) = new QueryBuilder(query.copy(attribute = Some(v)))
    def commitType(v: Commit.CommitType.CommitType) = new QueryBuilder(query.copy(commitType = Some(v)))
    def commiter(v: Commiter.Ref) = new QueryBuilder(query.copy(commiter = Some(v)))
    def timestamp(v: Instant) = new QueryBuilder(query.copy(timestamp = Some(v)))
  }

}

trait CommitsStorage extends Storage[Commit.Ref, Commit] with QueryableStorage[Commit] {
  import CommitsStorage._

  final val companion = CommitsStorage
  protected final def newQueryBuilder = new QueryBuilder(Query(None, None, None, None, None))
}