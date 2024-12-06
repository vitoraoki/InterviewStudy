package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.InsertPostModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.test.runTest
import org.junit.Test

class InsertPostsTest {

    private val repository: PostRepository = mockk()

    private val useCase = InsertPosts(repository)

    init {
        coEvery { repository.insertPosts(any()) } just runs
    }

    @Test
    fun `invoke verify insertPosts Repository call`() = runTest {
        val expected: List<InsertPostModel> = mockk()

        useCase(expected)

        coVerify(exactly = 1) {
            repository.insertPosts(expected)
        }
    }
}
