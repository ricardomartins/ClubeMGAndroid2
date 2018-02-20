package pt.rikmartins.clubemg.clubemgandroid.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Event

@Dao
abstract class EventDao {
    @Query(value = "SELECT * FROM events")
    abstract fun getAll(): LiveData<List<Event>>

    @Query(value = "SELECT * FROM events WHERE :startDate <= ending AND :endDate > starting") // Half-Open
    abstract fun getBetweenDates(startDate: DateTime, endDate: DateTime): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertEvent(events: Event)

    @Delete
    abstract fun deleteEvent(event: Event)

    @Update
    abstract fun updateEvent(event: Event)

    fun getMonth(year: Int, month: Int): LiveData<List<Event>> {
        val beginningOfMonth = DateTime(year, month, 15, 12, 30, DateTimeZone.forID("Europe/Lisbon"))
                .dayOfMonth().withMinimumValue().withTimeAtStartOfDay()
        val endOfMonth = beginningOfMonth.plusMonths(1)
                .dayOfMonth().withMinimumValue().withTimeAtStartOfDay()
        return getBetweenDates(beginningOfMonth, endOfMonth)
    }
}
