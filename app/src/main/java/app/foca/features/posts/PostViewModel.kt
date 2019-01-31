package app.foca.features.posts

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.foca.baseViewModel.BaseViewModel
import app.foca.model.Post
import app.foca.network.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostViewModel : BaseViewModel() {

    @Inject
    lateinit var postApi : PostApi

    lateinit var subscription : Disposable
    val loadingVisibility : MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickLister = View.OnClickListener { getPosts() }

    val postAdapter = AdapterPost()

    init {
        getPosts()
    }

    private fun getPosts() {
        subscription = postApi.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onStart() }
            .doOnTerminate { onTerminate() }
            .subscribe({
                onFetchData(it)
            },{
                onError(it)
            })
    }

    private fun onFetchData(postList: List<Post>?) {
        postAdapter.updatePostList(postList as List)
    }

    private fun onTerminate() {
        loadingVisibility.value = View.GONE
    }

    private fun onStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onError(throwable: Throwable){

    }



    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}