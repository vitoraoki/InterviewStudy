package com.programming.study.architecturesexample.data.repository

import com.programming.study.architecturesexample.data.database.entities.PostEntity
import com.programming.study.architecturesexample.data.datasource.PostDataSource
import com.programming.study.architecturesexample.domain.model.InsertPostModel
import com.programming.study.architecturesexample.domain.model.PostModel
import javax.inject.Inject

interface PostRepository {
    suspend fun insertPosts(posts: List<InsertPostModel>)

    suspend fun deletePost(post: PostModel)

    suspend fun deleteAllPosts()

    suspend fun updatePost(post: PostModel)

    suspend fun getAllPosts(): List<PostModel>
}

class PostRepositoryImpl @Inject constructor(
    private val postDataSource: PostDataSource
) : PostRepository {

    override suspend fun insertPosts(posts: List<InsertPostModel>) {
        posts.map(::mapInsertModelToEntity).let {
            postDataSource.insertPosts(it)
        }
    }

    override suspend fun deletePost(post: PostModel) {
        mapModelToEntity(post).let {
            postDataSource.deletePost(it)
        }
    }

    override suspend fun deleteAllPosts() {
        postDataSource.deleteAllPosts()
    }

    override suspend fun updatePost(post: PostModel) {
        mapModelToEntity(post).let {
            postDataSource.updatePost(it)
        }
    }

    override suspend fun getAllPosts(): List<PostModel> =
        postDataSource.getAllPosts().map(::mapEntityToModel)

    private fun mapInsertModelToEntity(insertModel: InsertPostModel): PostEntity =
        PostEntity(text = insertModel.text, isLiked = insertModel.isLiked)

    private fun mapModelToEntity(postModel: PostModel): PostEntity =
        PostEntity(id = postModel.id, text = postModel.text, isLiked = postModel.isLiked)

    private fun mapEntityToModel(postEntity: PostEntity): PostModel =
        PostModel(id = postEntity.id, text = postEntity.text, isLiked = postEntity.isLiked)
}
