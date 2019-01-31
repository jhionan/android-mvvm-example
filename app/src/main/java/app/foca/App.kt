package app.foca

import android.app.Application
import app.foca.injection.components.AppComponent
import app.foca.injection.modules.PostDaoModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val appComponent : AppComponent = DaggerAppComponent.builder()
            .appModule(this)
            .daoModule(PostDaoModule())
            .build()
    }
}