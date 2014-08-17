package net.locaman.api.data.storage

import net.locaman.api.data.objects.Commiter
import net.locaman.api.data.core.Storage

trait CommitersStorage extends Storage[Commiter.Ref, Commiter.Data] {

}