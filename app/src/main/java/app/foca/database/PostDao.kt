package app.foca.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import app.foca.model.Post

@Dao
interface PostDao {
    @get:Query("SELECT * FROM post")
    val all: List<Post>

    @Insert
    fun insertAll(vararg posts: Post)
}