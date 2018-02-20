package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.joda.time.DateTime

@Entity(tableName = "events_month")
class EventsMonth (@PrimaryKey val id: Long,
                   val year: Long, val month: Long,
                   @ColumnInfo(name = "last_update") val lastUpdate: DateTime)