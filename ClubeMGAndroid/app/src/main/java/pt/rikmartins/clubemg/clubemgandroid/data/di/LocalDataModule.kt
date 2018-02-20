package pt.rikmartins.clubemg.clubemgandroid.data.di

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import pt.rikmartins.clubemg.clubemgandroid.data.local.CmgDatabase
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.EventDao
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.EventsMonthDao
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.PostDao
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.TaxonomyDao
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): CmgDatabase {
        return Room.databaseBuilder(application, CmgDatabase::class.java, "cmg").build()
    }

    @Provides
    @Singleton
    fun provideEventDao(database: CmgDatabase): EventDao {
        return database.eventDao()
    }

    @Provides
    @Singleton
    fun provideEventsMonthDao(database: CmgDatabase): EventsMonthDao {
        return database.eventsMonthDao()
    }

    @Provides
    @Singleton
    fun providePostDao(database: CmgDatabase): PostDao {
        return database.postDao()
    }

    @Provides
    @Singleton
    fun provideTaxonomyDao(database: CmgDatabase): TaxonomyDao {
        return database.taxonomyDao()
    }
}
