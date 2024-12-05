package com.programming.study.architecturesexample.data.datasource

import com.programming.study.architecturesexample.data.database.entities.PostEntity

interface PostDataSource {
    suspend fun insertPosts(posts: List<PostEntity>)

    suspend fun deletePost(post: PostEntity)

    suspend fun deleteAllPosts()

    suspend fun updatePost(post: PostEntity)

    suspend fun getAllPosts(): List<PostEntity>
}
