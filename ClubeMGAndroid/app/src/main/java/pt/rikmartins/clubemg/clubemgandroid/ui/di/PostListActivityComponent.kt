package pt.rikmartins.clubemg.clubemgandroid.ui.di

import dagger.Module
import dagger.Subcomponent
import dagger.Provides
import pt.rikmartins.clubemg.clubemgandroid.ui.ActivityScope
import pt.rikmartins.clubemg.clubemgandroid.ui.posts.PostListActivity

@ActivityScope
@Subcomponent(modules = [PostListActivityComponent.PostListActivityModule::class])
interface PostListActivityComponent {

    fun inject(postListActivity: PostListActivity): PostListActivity

    @Module
    class PostListActivityModule(private val postListActivity: PostListActivity) {

        @Provides
        @ActivityScope
        fun providePublicacoesActivity(): PostListActivity {
            return postListActivity
        }
    }
}