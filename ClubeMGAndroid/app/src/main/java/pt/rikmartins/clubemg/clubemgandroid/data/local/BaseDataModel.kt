package pt.rikmartins.clubemg.clubemgandroid.data.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

abstract class BaseDataModel(@PrimaryKey(autoGenerate = true) val id: Long?,
                             @ColumnInfo(name = "api_id") val apiId: Long?,
                             @ColumnInfo(name = "self_link") val selfLink: DataLink?) {
    constructor() : this(null, null, null)
}