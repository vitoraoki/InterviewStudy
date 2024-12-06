package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.PostModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UpdatePostTest {

    private val repository: PostRepository = mockk()

    private val useCase = UpdatePost(repository)

    init {
        coEvery { repository.updatePost(any()) } just runs
    }

    @Test
    fun `invoke verify updatePost Repository call`() = runTest {
        val expected: PostModel = mockk()

        useCase(expected)

        coVerify(exactly = 1) {
            repository.updatePost(expected)
        }
    }
}
