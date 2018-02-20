package pt.rikmartins.clubemg.clubemgandroid.ui

import android.content.Intent
import android.os.Bundle
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import pt.rikmartins.clubemg.clubemgandroid.BaseActivity
import pt.rikmartins.clubemg.clubemgandroid.CmgApplication
import pt.rikmartins.clubemg.clubemgandroid.R
import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent
import pt.rikmartins.clubemg.clubemgandroid.ui.di.SplashActivityComponent
import pt.rikmartins.clubemg.clubemgandroid.ui.posts.PostListActivity


class SplashActivity : BaseActivity() {
    override fun setupActivityComponent(appComponent: AppComponent) {
        appComponent.plus(SplashActivityComponent.SplashActivityModule(this))
                .inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Single.create<String> {
            // TODO: Loading that may be important to do should go somewhere here
            it.onSuccess("Feito")
        }.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(Consumer {
            nextActivity()
            finish() // Remove this activity from the task
        })

        // TODO: Ubiquitous permissions should also go somewhere here
    }

    private fun nextActivity() {
        // TODO: Selection of activity where to forward
        // This may be dependant on some inner state
        // Tutorial if first time it's run
        // Some other activity if it was the last one to be used
        startActivity(Intent(this, PostListActivity::class.java), Bundle.EMPTY)
    }


}
