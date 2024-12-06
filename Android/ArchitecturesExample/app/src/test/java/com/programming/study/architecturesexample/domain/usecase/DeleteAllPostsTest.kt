package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DeleteAllPostsTest {

    private val repository: PostRepository = mockk()

    private val useCase = DeleteAllPosts(repository)

    init {
        coEvery { repository.deleteAllPosts() } just runs
    }

    @Test
    fun `invoke verify deleteAllPosts Repository call`() = runTest {
        useCase()

        coVerify(exactly = 1) {
            repository.deleteAllPosts()
        }
    }
}
