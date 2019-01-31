package app.foca.injection.modules

import android.content.Context
import androidx.room.Room
import app.foca.database.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PostDaoModule {

    @Provides
    fun providePostDb(context: Context) : AppDataBase = Room.databaseBuilder(context, AppDataBase::class.java, "posts").build()
}