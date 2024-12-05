package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.PostModel
import javax.inject.Inject

interface UpdatePostUseCase {
    suspend operator fun invoke(post: PostModel)
}

class UpdatePost @Inject constructor(
    private val repository: PostRepository
): UpdatePostUseCase {

    override suspend fun invoke(post: PostModel) {
        repository.updatePost(post)
    }
}
