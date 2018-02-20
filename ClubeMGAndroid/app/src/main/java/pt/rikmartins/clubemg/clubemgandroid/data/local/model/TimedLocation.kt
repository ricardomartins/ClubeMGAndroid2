package pt.rikmartins.clubemg.clubemgandroid.data.local.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import org.joda.time.DateTime
import pt.rikmartins.clubemg.clubemgandroid.data.local.BaseDataModel
import pt.rikmartins.clubemg.clubemgandroid.data.local.DataLink

@Entity(tableName = "timed_locations",
        foreignKeys = [ForeignKey(entity = Event::class, parentColumns = ["id"], childColumns = ["event_id"], onDelete = ForeignKey.CASCADE)])
class TimedLocation(id: Long, apiId: Long, selfLink: DataLink,
                    @ColumnInfo(name = "event_id") val eventId: Long,
                    val designation: String,
                    val order: Int,
                    @ColumnInfo(name = " date_time") val dateTime: DateTime,
                    val latitude: Double,
                    val longitude: Double)
    : BaseDataModel(id, apiId, selfLink)
