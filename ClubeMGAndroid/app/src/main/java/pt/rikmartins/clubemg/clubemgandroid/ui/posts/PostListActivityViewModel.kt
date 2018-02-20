package pt.rikmartins.clubemg.clubemgandroid.ui.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Post

class PostListActivityViewModel : ViewModel() {
    val mPublicacoes: MutableLiveData<List<Post>> = MutableLiveData()

    fun setPublicacoes(publicacoes: List<Post>) {
        mPublicacoes.postValue(publicacoes)
    }
}