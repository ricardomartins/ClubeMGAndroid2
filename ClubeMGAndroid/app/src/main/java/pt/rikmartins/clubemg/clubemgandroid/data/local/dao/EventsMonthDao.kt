package pt.rikmartins.clubemg.clubemgandroid.data.local.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.EventsMonth

@Dao
interface EventsMonthDao {
    @Query(value = "SELECT * FROM events_month")
    fun getAll(): List<EventsMonth>

    @Query(value = "SELECT * FROM events_month WHERE id = :id")
    fun getOne(id: Long): List<EventsMonth>

    @Query(value = "SELECT * FROM events_month WHERE year = :year AND month = :month")
    fun getOne(year: Int, month: Int): List<EventsMonth>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvent(events: EventsMonth)

    @Delete
    fun deleteEvent(event: EventsMonth)

    @Update
    fun updateEvent(event: EventsMonth)
}
