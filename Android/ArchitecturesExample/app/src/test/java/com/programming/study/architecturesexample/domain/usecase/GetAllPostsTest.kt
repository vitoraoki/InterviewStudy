package com.programming.study.architecturesexample.domain.usecase

import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.domain.model.PostModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetAllPostsTest {

    private val repository: PostRepository = mockk()

    private val useCase = GetAllPosts(repository)

    @Test
    fun `invoke verify getAllPosts Repository call`() = runTest {
        coEvery { repository.getAllPosts() } returns listOf()

        useCase()

        coVerify(exactly = 1) {
            repository.getAllPosts()
        }
    }

    @Test
    fun `invoke assert list of PostModel`() = runTest {
        val expected: List<PostModel> = listOf()
        coEvery { repository.getAllPosts() } returns expected

        val actual = useCase()

        assertEquals(expected, actual)
    }
}
