package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.PostModel
import javax.inject.Inject

interface GetAllPostsUseCase {
    suspend operator fun invoke(): List<PostModel>
}

class GetAllPosts @Inject constructor(
    private val repository: PostRepository
): GetAllPostsUseCase {

    override suspend fun invoke(): List<PostModel> = repository.getAllPosts()
}
