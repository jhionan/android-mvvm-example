package app.foca.injection.components

import app.foca.features.posts.PostViewModel
import app.foca.injection.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component (modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {


    fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build() : NetworkComponent
        fun networkModule(networkmodule : NetworkModule) : Builder
    }

}