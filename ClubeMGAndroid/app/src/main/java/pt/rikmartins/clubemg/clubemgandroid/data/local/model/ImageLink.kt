package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import pt.rikmartins.clubemg.clubemgandroid.data.local.BaseDataModel
import pt.rikmartins.clubemg.clubemgandroid.data.local.DataLink

@Entity(tableName = "image_link",
        foreignKeys = [ForeignKey(entity = Post::class, parentColumns = ["id"], childColumns = ["post_id"], onDelete = ForeignKey.CASCADE)])
class ImageLink(id: Long, apiId: Long, selfLink: DataLink,
                @ColumnInfo(name = "post_id") val postId: Long,
                val title: String,
                val size: String,
                val width: Long,
                val height: Long,
                val link: String,
                @ColumnInfo(name = "media_type") val mediaType: String,
                @ColumnInfo(name = "mime_type") val mimeType: String,
                val file: String)
    : BaseDataModel(id, apiId, selfLink)
