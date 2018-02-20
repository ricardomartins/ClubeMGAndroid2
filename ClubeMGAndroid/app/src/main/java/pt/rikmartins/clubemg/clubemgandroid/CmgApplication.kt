package pt.rikmartins.clubemg.clubemgandroid

import android.app.Application
import android.content.Context

import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent
import pt.rikmartins.clubemg.clubemgandroid.di.DaggerAppComponent

class CmgApplication : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppComponent.AppModule(this))
                .build()
    }

    companion object {
        operator fun get(context: Context): CmgApplication {
            return context.applicationContext as CmgApplication
        }
    }
}
