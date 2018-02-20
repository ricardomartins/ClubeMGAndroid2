package pt.rikmartins.clubemg.clubemgandroid.data.local

import android.arch.persistence.room.TypeConverter
import org.joda.time.DateTime

class DataBaseConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): DateTime? = if (value == null) null else DateTime(value)

    @TypeConverter
    fun dateToTimestamp(dateTime: DateTime?): Long? = dateTime?.millis

    @TypeConverter
    fun toDataLink(dataLink: DataLink?): String? = if (dataLink == null) null else ((if (dataLink.obtained) "1" else "0") + dataLink.link)

    @TypeConverter
    fun fromDataLink(value: String?): DataLink? = if (value == null) null else DataLink(value.substring(1), value[0] == '1')
}