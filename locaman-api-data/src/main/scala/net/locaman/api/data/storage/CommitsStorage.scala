package net.locaman.api.data.storage

import net.locaman.api.data.core.Storage
import net.locaman.api.data.objects.Commit

trait CommitsStorage extends Storage[Commit.Ref, Commit] {

}