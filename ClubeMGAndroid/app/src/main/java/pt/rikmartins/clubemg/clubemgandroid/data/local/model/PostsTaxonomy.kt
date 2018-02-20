package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(tableName = "posts_taxonomies",
        primaryKeys = ["taxonomy_id", "post_id"],
        foreignKeys = [
            ForeignKey(entity = Taxonomy::class, parentColumns = ["id"], childColumns = ["taxonomy_id"], onDelete = ForeignKey.CASCADE),
            ForeignKey(entity = Post::class, parentColumns = ["id"], childColumns = ["post_id"], onDelete = ForeignKey.CASCADE)
        ])
data class PostsTaxonomy(@ColumnInfo(name = "taxonomy_id") val taxonomyId: Long? = null,
                         @ColumnInfo(name = "event_id") val postId: Long? = null)