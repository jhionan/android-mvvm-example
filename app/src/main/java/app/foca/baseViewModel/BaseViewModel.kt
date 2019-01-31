package app.foca.baseViewModel

import androidx.lifecycle.ViewModel
import app.foca.features.posts.PostViewModel
import app.foca.injection.components.DaggerNetworkComponent
import app.foca.injection.components.NetworkComponent
import app.foca.injection.modules.NetworkModule

abstract class BaseViewModel : ViewModel() {

    private val injector : NetworkComponent = DaggerNetworkComponent.builder().networkModule(NetworkModule).build()

    init {
        inject()
    }

    private fun inject(){
        when(this){
            is PostViewModel -> injector.inject(this)
        }
    }
}