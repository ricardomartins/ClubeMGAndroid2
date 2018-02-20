package pt.rikmartins.clubemg.clubemgandroid.di

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import pt.rikmartins.clubemg.clubemgandroid.AppExecutors
import pt.rikmartins.clubemg.clubemgandroid.data.di.ApiCmgModule
import pt.rikmartins.clubemg.clubemgandroid.data.di.IntermediateModule
import pt.rikmartins.clubemg.clubemgandroid.data.di.LocalDataModule
import pt.rikmartins.clubemg.clubemgandroid.ui.di.*
import javax.inject.Singleton
import java.util.concurrent.Executors


@Singleton
@Component(modules = [AppComponent.AppModule::class, ApiCmgModule::class, IntermediateModule::class,
    LocalDataModule::class])
interface AppComponent {

    fun plus(module: SplashActivityComponent.SplashActivityModule): SplashActivityComponent

    fun plus(module: PostListActivityComponent.PostListActivityModule): PostListActivityComponent

    fun plus(module: SinglePostActivityComponent.SinglePostActivityModule): SinglePostActivityComponent

    fun plus(module: EventListActivityComponent.EventListActivityModule): EventListActivityComponent

    fun plus(module: SingleEventActivityComponent.SingleEventActivityModule): SingleEventActivityComponent

    @Module
    class AppModule(private val application: Application) {
        @Provides
        @Singleton
        fun provideApplication(): Application = application

        @Provides
        @Singleton
        fun provideAppExecutors(): AppExecutors = AppExecutors(Executors.newSingleThreadExecutor(),
                Executors.newFixedThreadPool(3),
                AppExecutors.MainThreadExecutor())
    }
}
