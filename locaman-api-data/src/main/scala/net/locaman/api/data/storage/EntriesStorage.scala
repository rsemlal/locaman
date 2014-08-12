package net.locaman.api.data.storage

import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Entry

trait EntriesStorage extends Storage[Entry.Ref, Entry] {

}