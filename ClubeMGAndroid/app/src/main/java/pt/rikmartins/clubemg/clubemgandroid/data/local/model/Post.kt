package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import pt.rikmartins.clubemg.clubemgandroid.data.local.DataLink
import pt.rikmartins.clubemg.clubemgandroid.data.local.TaxonomicDataModel

@Entity(tableName = "posts")
class Post(id: Long, apiId: Long, selfLink: DataLink, taxonomiesLink: DataLink,
           val title: String,
           val slug: String,
           val sticky: Boolean,
           val excerpt: String,
           val content: String,
           val date: String,
           @ColumnInfo(name = "time_stamp") val timeStamp: Long,
           @ColumnInfo(name = "date_modified") val dateModified: String,
           @ColumnInfo(name = "media_link") val mediaLink: DataLink)
    : TaxonomicDataModel(id, apiId, selfLink, taxonomiesLink)