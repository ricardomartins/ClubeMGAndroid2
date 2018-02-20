package pt.rikmartins.clubemg.clubemgandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent

abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActivityComponent(CmgApplication[this].appComponent)
    }

    protected abstract fun setupActivityComponent(appComponent: AppComponent)
}
