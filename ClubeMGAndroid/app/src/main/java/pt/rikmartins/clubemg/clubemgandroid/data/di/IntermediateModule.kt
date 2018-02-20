package pt.rikmartins.clubemg.clubemgandroid.data.di

import dagger.Module
import dagger.Provides
import pt.rikmartins.clubemg.clubemgandroid.AppExecutors
import pt.rikmartins.clubemg.clubemgandroid.data.EventConverter
import pt.rikmartins.clubemg.clubemgandroid.data.EventsRepository
import pt.rikmartins.clubemg.clubemgandroid.data.PostConverter
import pt.rikmartins.clubemg.clubemgandroid.data.TaxonomyConverter
import pt.rikmartins.clubemg.clubemgandroid.data.cmgapi.EventsApi
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.EventDao
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.EventsMonthDao
import javax.inject.Singleton

@Module
class IntermediateModule {
    @Provides
    @Singleton
    fun provideEventConverter(): EventConverter {
        return EventConverter()
    }

    @Provides
    @Singleton
    fun providePostConverter(): PostConverter {
        return PostConverter()
    }

    @Provides
    @Singleton
    fun provideTaxonomyConverter(): TaxonomyConverter {
        return TaxonomyConverter()
    }

    @Provides
    @Singleton
    fun provideEventsRepository(actividadesApi: EventsApi, eventDao: EventDao, eventsMonthDao: EventsMonthDao,
                          eventConverter: EventConverter, appExecutors: AppExecutors): EventsRepository {
        return EventsRepository(actividadesApi, eventDao, eventsMonthDao, eventConverter, appExecutors)
    }


}
