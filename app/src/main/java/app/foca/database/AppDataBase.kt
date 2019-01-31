package app.foca.database

import androidx.room.Database
import androidx.room.RoomDatabase
import app.foca.model.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun postDao() : PostDao
}