package pt.rikmartins.clubemg.clubemgandroid.data.local.dao

import android.arch.persistence.room.*
import pt.rikmartins.clubemg.clubemgandroid.data.local.model.Post

@Dao
interface PostDao {
    @Query(value = "SELECT * FROM posts")
    fun getAll(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(posts: Post)

    @Delete
    fun deletePost(post: Post)

    @Update
    fun updatePost(post: Post)
}