package pt.rikmartins.clubemg.clubemgandroid.ui.events

import pt.rikmartins.clubemg.clubemgandroid.BaseActivity
import pt.rikmartins.clubemg.clubemgandroid.R
import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent
import pt.rikmartins.clubemg.clubemgandroid.ui.di.SingleEventActivityComponent

class SingleEventActivity : BaseActivity() {
    override fun setupActivityComponent(appComponent: AppComponent) {
        appComponent.plus(SingleEventActivityComponent.SingleEventActivityModule(this))
                .inject(this)
        setContentView(R.layout.activity_single_event)
    }
}
