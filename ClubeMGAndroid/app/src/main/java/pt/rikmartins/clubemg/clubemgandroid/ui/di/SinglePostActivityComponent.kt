package pt.rikmartins.clubemg.clubemgandroid.ui.di

import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import pt.rikmartins.clubemg.clubemgandroid.ui.ActivityScope
import pt.rikmartins.clubemg.clubemgandroid.ui.posts.SinglePostActivity

@ActivityScope
@Subcomponent(modules = [SinglePostActivityComponent.SinglePostActivityModule::class])
interface SinglePostActivityComponent {

    fun inject(singlePostActivity: SinglePostActivity): SinglePostActivity

    @Module
    class SinglePostActivityModule(private val singlePostActivity: SinglePostActivity) {

        @Provides
        @ActivityScope
        fun providePublicacaoActivity(): SinglePostActivity {
            return singlePostActivity
        }
    }
}