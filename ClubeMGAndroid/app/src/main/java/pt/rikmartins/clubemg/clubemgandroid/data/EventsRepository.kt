package pt.rikmartins.clubemg.clubemgandroid.data

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import org.joda.time.DateTime
import org.joda.time.Duration
import pt.rikmartins.clubemg.clubemgandroid.AppExecutors
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.EventsApi
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.model.ApiEvent
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.EventDao
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.EventsMonthDao
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Event

class EventsRepository(private val eventsApi: EventsApi, private val eventDao: EventDao, private val eventsMonthDao: EventsMonthDao,
                       private val eventConverter: EventConverter, private val executors: AppExecutors) {
    companion object {
        val FRESHNESS: Duration = Duration.standardHours(4) // Arbitrary value
    }

    private val cache: MutableMap<Int, EventsLiveData> = mutableMapOf()

    fun getEventsOfMonth(year: Int, month: Int): EventsLiveData {
        val key = year * 100 + month
        return if (cache.containsKey(key)) cache[key]!! else {
            val newELV = EventsLiveData(year, month, this)
            cache[key] = newELV
            newELV
        }
    }

    fun refresh() {
        cache.onEach { it.value.fetch(true) }
    }

    private fun shouldBeStored(year: Int, month: Int): Boolean {
        return false // TODO: This line should eventually be removed
        val now = DateTime()

        val inferiorLimit = now.minusMonths(1) // Arbitrary value
        val infYear = inferiorLimit.year
        if (year < infYear || (year == infYear && month < inferiorLimit.monthOfYear)) return false

        val superiorLimit = now.plusMonths(3) // Arbitrary value
        val supYear = superiorLimit.year
        if (year > supYear || (year == supYear && month > superiorLimit.monthOfYear)) return false

        return true
    }

    class EventsLiveData(private val year: Int, private val month: Int, private val repository: EventsRepository) : MediatorLiveData<List<Event>>() {
        private val dbEvents = repository.eventDao.getMonth(year, month)
        private val algo = MutableLiveData<List<Event>>()

        init {
            addSource(dbEvents, { value = it })
            addSource(algo, { value = it })
        }

        fun fetch(force: Boolean = true) {
            repository.executors.diskIO.execute {
                val shouldBeStored = repository.shouldBeStored(year, month)
                var refreshNeeded = false
                if (!force && shouldBeStored) {
                    val eventsMonth = repository.eventsMonthDao.getOne(year, month)
                    refreshNeeded = eventsMonth.isNotEmpty() && eventsMonth[0].lastUpdate.withDurationAdded(FRESHNESS, 1).isBeforeNow
                }
                if (refreshNeeded || force) {
                    val fetchedMonth: List<ApiEvent> = repository.eventsApi.fetchMonth(year, month).execute().body()!! // TODO: This can easily cause errors, solve it
                    val convertedFetchedMonth = repository.eventConverter.apiToLocalList(fetchedMonth)
                    if (shouldBeStored) {
                        // TODO: Store the EventsMonth into the database
                        // TODO: Check for changes to each event before inserting it
                        // TODO: Insert the events
                    } else {
                        // TODO: Check for differences before posting
                        algo.postValue(convertedFetchedMonth)
                    }
                }
            }
        }
    }
}
