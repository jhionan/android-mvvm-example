package app.foca.injection.modules

import android.content.Context
import app.foca.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(app: App) : Context = app
}