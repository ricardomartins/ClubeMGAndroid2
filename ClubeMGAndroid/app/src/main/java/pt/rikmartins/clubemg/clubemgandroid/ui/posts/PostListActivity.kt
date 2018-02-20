package pt.rikmartins.clubemg.clubemgandroid.ui.posts

import pt.rikmartins.clubemg.clubemgandroid.BaseActivity
import pt.rikmartins.clubemg.clubemgandroid.di.AppComponent
import pt.rikmartins.clubemg.clubemgandroid.ui.di.PostListActivityComponent

class PostListActivity : BaseActivity() {
    override fun setupActivityComponent(appComponent: AppComponent) {
        appComponent.plus(PostListActivityComponent.PostListActivityModule(this))
                .inject(this)
    }
}
