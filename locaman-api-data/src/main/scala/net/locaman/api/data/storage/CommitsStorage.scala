package net.locaman.api.data.storage

import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Commit
import net.locaman.api.data.objects.Commiter
import org.joda.time.Instant
import net.locaman.api.data.objects.Entry
import net.locaman.api.data.objects.Attribute

trait CommitsStorage extends Storage[Commit.Ref, Commit] {
  def list(
    entryRef: Option[Entry.Ref] = None,
    attributeRef: Option[Attribute.Ref] = None,
    commitType: Option[Commit.CommitType.CommitType] = None,
    commiter: Option[Commiter.Ref] = None,
    timestamp: Option[Instant] = None): Seq[Commit]
}