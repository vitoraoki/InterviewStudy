package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.PostModel
import javax.inject.Inject

interface DeletePostUseCase {
    suspend operator fun invoke(post: PostModel)
}

class DeletePost @Inject constructor(
    private val repository: PostRepository
): DeletePostUseCase {

    override suspend fun invoke(post: PostModel) {
        repository.deletePost(post)
    }
}
