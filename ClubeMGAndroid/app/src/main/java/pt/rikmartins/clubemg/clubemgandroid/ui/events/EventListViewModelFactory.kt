package pt.rikmartins.clubemg.clubemgandroid.ui.events

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import pt.rikmartins.clubemg.clubemgandroid.data.EventsRepository

class EventListViewModelFactory(private val repository: EventsRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return EventListViewModel(repository) as T
    }
}