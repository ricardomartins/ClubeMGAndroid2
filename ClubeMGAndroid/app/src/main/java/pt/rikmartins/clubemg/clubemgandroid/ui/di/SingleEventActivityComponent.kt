package pt.rikmartins.clubemg.clubemgandroid.ui.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import pt.rikmartins.clubemg.clubemgandroid.ui.ActivityScope
import pt.rikmartins.clubemg.clubemgandroid.ui.events.SingleEventActivity

@ActivityScope
@Subcomponent(modules = [SingleEventActivityComponent.SingleEventActivityModule::class])
interface SingleEventActivityComponent {

    fun inject(singleEventActivity: SingleEventActivity): SingleEventActivity

    @Module
    class SingleEventActivityModule(private val singleEventActivity: SingleEventActivity) {

        @Provides
        @ActivityScope
        fun provideSingleEventActivity(): SingleEventActivity {
            return singleEventActivity
        }
    }
}