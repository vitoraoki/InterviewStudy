package com.programming.study.architecturesexample.data.datasource

import com.programming.study.architecturesexample.data.database.dao.PostDao
import com.programming.study.architecturesexample.data.database.entities.PostEntity
import javax.inject.Inject

class PostLocalDataSource @Inject constructor(
    private val postDao: PostDao
) : PostDataSource {

    override suspend fun insertPosts(posts: List<PostEntity>) {
        postDao.insertPosts(posts)
    }

    override suspend fun deletePost(post: PostEntity) {
        postDao.deletePost(post)
    }

    override suspend fun deleteAllPosts() {
        postDao.deleteAllPosts()
    }

    override suspend fun updatePost(post: PostEntity) {
        postDao.updatePost(post)
    }

    override suspend fun getAllPosts(): List<PostEntity> = postDao.getAllPosts()
}
