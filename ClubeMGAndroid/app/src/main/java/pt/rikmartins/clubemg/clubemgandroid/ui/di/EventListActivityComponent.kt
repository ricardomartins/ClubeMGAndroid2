package pt.rikmartins.clubemg.clubemgandroid.ui.di

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Subcomponent
import dagger.Provides
import pt.rikmartins.clubemg.clubemgandroid.data.EventsRepository
import pt.rikmartins.clubemg.clubemgandroid.ui.ActivityScope
import pt.rikmartins.clubemg.clubemgandroid.ui.events.EventListActivity
import pt.rikmartins.clubemg.clubemgandroid.ui.events.EventListViewModel
import pt.rikmartins.clubemg.clubemgandroid.ui.events.EventListViewModelFactory

@ActivityScope
@Subcomponent(modules = [EventListActivityComponent.EventListActivityModule::class])
interface EventListActivityComponent {

    fun inject(eventListActivity: EventListActivity): EventListActivity

    @Module
    class EventListActivityModule(private val eventListActivity: EventListActivity) {
        @Provides
        @ActivityScope
        fun provideEventListActivity(): EventListActivity {
            return eventListActivity
        }

        @Provides
        @ActivityScope
        fun provideEventListViewModel(activity: EventListActivity, repository: EventsRepository): EventListViewModel {
            val factory = EventListViewModelFactory(repository)
            return ViewModelProviders.of(activity, factory).get(EventListViewModel::class.java)
        }
    }
}