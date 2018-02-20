package pt.rikmartins.clubemg.clubemgandroid.ui.events

import android.os.Bundle
import pt.rikmartins.clubemg.clubemgandroid.BaseActivity
import pt.rikmartins.clubemg.clubemgandroid.R
import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent
import pt.rikmartins.clubemg.clubemgandroid.ui.di.EventListActivityComponent
import javax.inject.Inject

class EventListActivity : BaseActivity() {
    @Inject
    lateinit var viewModel: EventListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)
    }

    override fun setupActivityComponent(appComponent: AppComponent)  {
        appComponent.plus(EventListActivityComponent.EventListActivityModule(this))
                .inject(this)
    }
}
