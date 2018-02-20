package pt.rikmartins.clubemg.clubemgandroid.ui.di

import dagger.Module
import dagger.Subcomponent
import pt.rikmartins.clubemg.clubemgandroid.ui.SplashActivity
import dagger.Provides
import pt.rikmartins.clubemg.clubemgandroid.ui.ActivityScope

@ActivityScope
@Subcomponent(modules = [SplashActivityComponent.SplashActivityModule::class])
interface SplashActivityComponent {

    fun inject(splashActivity: SplashActivity): SplashActivity

    @Module
    class SplashActivityModule(private val splashActivity: SplashActivity) {

        @Provides
        @ActivityScope
        fun provideSplashActivity(): SplashActivity {
            return splashActivity
        }
    }
}