package pt.rikmartins.clubemg.clubemgandroid.ui.posts

import pt.rikmartins.clubemg.clubemgandroid.BaseActivity
import pt.rikmartins.clubemg.clubemgandroid.R
import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent
import pt.rikmartins.clubemg.clubemgandroid.ui.di.SinglePostActivityComponent

class SinglePostActivity : BaseActivity() {
    override fun setupActivityComponent(appComponent: AppComponent) {
        appComponent.plus(SinglePostActivityComponent.SinglePostActivityModule(this))
                .inject(this)
        setContentView(R.layout.activity_single_event)
    }
}
