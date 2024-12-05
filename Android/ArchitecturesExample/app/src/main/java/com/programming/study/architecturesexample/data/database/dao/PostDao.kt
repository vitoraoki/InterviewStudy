package com.programming.study.architecturesexample.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.programming.study.architecturesexample.data.database.entities.POST_TABLE_NAME
import com.programming.study.architecturesexample.data.database.entities.PostEntity

const val QUERY_GET_ALL_POSTS = "SELECT * FROM $POST_TABLE_NAME"
const val QUERY_DELETE_ALL_POSTS = "DELETE FROM $POST_TABLE_NAME"

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPosts(vararg posts: PostEntity)

    @Delete
    fun deletePost(post: PostEntity)

    @Query(QUERY_DELETE_ALL_POSTS)
    fun deleteAllPosts()

    @Update
    fun updatePost(post: PostEntity)

    @Query(QUERY_GET_ALL_POSTS)
    fun getAllPosts(): List<PostEntity>
}
