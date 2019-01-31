package app.foca.features.posts

import androidx.lifecycle.MutableLiveData
import app.foca.baseViewModel.BaseViewModel
import app.foca.model.Post

class AdapterPostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()



    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle() = postTitle

    fun getPostBody() = postBody

}