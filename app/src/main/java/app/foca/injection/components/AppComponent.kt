package app.foca.injection.components

import android.content.Context
import app.foca.App
import app.foca.database.AppDataBase
import app.foca.features.posts.PostViewModel
import app.foca.injection.modules.AppModule
import app.foca.injection.modules.PostDaoModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PostDaoModule::class])
interface AppComponent {

    fun  getContext() : Context
    fun dao() : AppDataBase


    @Component.Builder
    interface Builder{
        @BindsInstance
        fun appModule(app: App) : Builder
        fun daoModule(postDaoModule: PostDaoModule) : Builder
        fun build() : AppComponent
    }


}