package pt.rikmartins.clubemg.clubemgandroid.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import pt.rikmartins.clubemg.clubemgandroid.data.local.dao.*
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.*

@Database(entities = [Event::class, EventsMonth::class, EventsTaxonomy::class, ImageLink::class, Post::class,
    PostAboutEvent::class, PostsTaxonomy::class, Taxonomy::class, TimedLocation::class],
        version = 1)
@TypeConverters(DataBaseConverters::class)
abstract class CmgDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun eventsMonthDao(): EventsMonthDao
    abstract fun postDao(): PostDao
    abstract fun taxonomyDao(): TaxonomyDao
}
