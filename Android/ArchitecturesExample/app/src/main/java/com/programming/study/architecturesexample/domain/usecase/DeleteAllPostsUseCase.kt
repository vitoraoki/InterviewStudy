package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import javax.inject.Inject

interface DeleteAllPostsUseCase {
    suspend operator fun invoke()
}

class DeleteAllPosts @Inject constructor(
    private val repository: PostRepository
) : DeleteAllPostsUseCase {

    override suspend fun invoke() {
        repository.deleteAllPosts()
    }
}
