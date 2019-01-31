package app.foca.features.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.foca.R
import app.foca.databinding.ItemPostBinding
import app.foca.model.Post

class AdapterPost : RecyclerView.Adapter<AdapterPost.VH>() {

    private lateinit var postList : List<Post>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPost.VH {
        val binding : ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return VH(binding)
    }

    override fun getItemCount() = if (::postList.isInitialized) postList.size else 0

    override fun onBindViewHolder(holder: AdapterPost.VH, position: Int) {
        holder.bind(postList[position])
    }

    fun updatePostList(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class VH(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = AdapterPostViewModel()
        fun bind(post: Post) {
            viewModel.bind(post)
            binding.viewModel = viewModel
        }

    }
}
