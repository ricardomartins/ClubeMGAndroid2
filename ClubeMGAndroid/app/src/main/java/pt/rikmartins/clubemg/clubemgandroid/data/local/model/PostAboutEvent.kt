package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(tableName = "posts_about_events",
        primaryKeys = ["post_id", "event_id"],
        foreignKeys = [
            ForeignKey(entity = Post::class, parentColumns = ["id"], childColumns = ["post_id"], onDelete = ForeignKey.CASCADE),
            ForeignKey(entity = Event::class, parentColumns = ["id"], childColumns = ["event_id"], onDelete = ForeignKey.CASCADE)
        ])
data class PostAboutEvent(@ColumnInfo(name = "post_id") val postId: Long,
                     @ColumnInfo(name = "event_id") val eventId: Long)
