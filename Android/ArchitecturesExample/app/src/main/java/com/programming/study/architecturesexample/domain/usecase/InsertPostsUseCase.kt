package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.InsertPostModel
import javax.inject.Inject

interface InsertPostsUseCase {
    suspend operator fun invoke(posts: List<InsertPostModel>)
}

class InsertPosts @Inject constructor(
    private val repository: PostRepository
) : InsertPostsUseCase {

    override suspend fun invoke(posts: List<InsertPostModel>) {
        repository.insertPosts(posts)
    }
}
