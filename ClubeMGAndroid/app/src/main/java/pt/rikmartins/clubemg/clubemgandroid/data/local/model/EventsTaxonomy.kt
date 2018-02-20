package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey

@Entity(tableName = "events_taxonomies",
        primaryKeys = ["taxonomy_id", "event_id"],
        foreignKeys = [
            ForeignKey(entity = Taxonomy::class, parentColumns = ["id"], childColumns = ["taxonomy_id"], onDelete = ForeignKey.CASCADE),
            ForeignKey(entity = Event::class, parentColumns = ["id"], childColumns = ["event_id"], onDelete = ForeignKey.CASCADE)
        ])
class EventsTaxonomy(@ColumnInfo(name = "taxonomy_id") val taxonomyId: Long,
                     @ColumnInfo(name = "event_id") val eventId: Long)