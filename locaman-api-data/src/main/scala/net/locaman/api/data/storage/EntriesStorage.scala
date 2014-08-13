package net.locaman.api.data.storage

import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Entry
import net.locaman.api.data.objects.EntryType

trait EntriesStorage extends Storage[Entry.Ref, Entry] {
  def list(entryType: EntryType.Ref): Seq[Entry]
}