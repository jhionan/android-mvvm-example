package app.foca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.foca.databinding.ActivityMainBinding
import app.foca.features.posts.PostViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : PostViewModel
    private lateinit var binding : ActivityMainBinding
    private var erroSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PostViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.root.rv_post.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.viewModel = viewModel
        viewModel.errorMessage.observe(this, Observer{erroMessage ->
            if (erroMessage!=null) showError(erroMessage) else hideError()

        })
    }

    private fun hideError() {
        erroSnackbar?.dismiss()
    }

    private fun showError(@StringRes erroMessage: Int) {
        erroSnackbar = Snackbar.make(binding.root, erroMessage, Snackbar.LENGTH_INDEFINITE)
        erroSnackbar?.setAction(R.string.retry, viewModel.errorClickLister)
        erroSnackbar?.show()
    }
}
