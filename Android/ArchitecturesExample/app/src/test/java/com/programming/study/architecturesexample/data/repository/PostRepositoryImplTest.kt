package com.programming.study.architecturesexample.data.repository

import com.programming.study.architecturesexample.data.database.entities.PostEntity
import com.programming.study.architecturesexample.data.datasource.PostDataSource
import com.programming.study.architecturesexample.domain.model.InsertPostModel
import com.programming.study.architecturesexample.domain.model.PostModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PostRepositoryImplTest {

    private val postDataSource: PostDataSource = mockk()

    private val repository = PostRepositoryImpl(postDataSource)

    init {
        coEvery { postDataSource.insertPosts(any()) } just runs
        coEvery { postDataSource.deletePost(any()) } just runs
        coEvery { postDataSource.deleteAllPosts() } just runs
        coEvery { postDataSource.updatePost(any()) } just runs
    }

    @Test
    fun `insertPosts verify insertPosts Data Source call`() = runTest {
        val insertPostModel = InsertPostModel(text = "text")
        val postEntity = PostEntity(id = 0, text = insertPostModel.text, isLiked = false)

        repository.insertPosts(listOf(insertPostModel))

        coVerify(exactly = 1) {
            postDataSource.insertPosts(listOf(postEntity))
        }
    }

    @Test
    fun `deletePost verify deletePost Data Source call`() = runTest {
        val postModel = PostModel(id = 0, text = "text", isLiked = true)
        val postEntity = PostEntity(
            id = postModel.id,
            text = postModel.text,
            isLiked = postModel.isLiked
        )

        repository.deletePost(postModel)

        coVerify(exactly = 1) {
            postDataSource.deletePost(postEntity)
        }
    }

    @Test
    fun `deleteAllPosts verify deleteAllPosts Data Source call`() = runTest {
        repository.deleteAllPosts()

        coVerify(exactly = 1) {
            postDataSource.deleteAllPosts()
        }
    }

    @Test
    fun `updatePost verify updatePost Data Source call`() = runTest {
        val postModel = PostModel(id = 0, text = "text", isLiked = true)
        val postEntity = PostEntity(
            id = postModel.id,
            text = postModel.text,
            isLiked = postModel.isLiked
        )

        repository.updatePost(postModel)

        coVerify(exactly = 1) {
            postDataSource.updatePost(postEntity)
        }
    }

    @Test
    fun `getAllPosts verify getAllPosts Data Source call`() = runTest {
        coEvery { postDataSource.getAllPosts() } returns listOf()

        repository.getAllPosts()

        coVerify(exactly = 1) {
            postDataSource.getAllPosts()
        }
    }

    @Test
    fun `getAllPosts assert list of PostModel`() = runTest {
        val postModel = PostModel(id = 0, text = "text", isLiked = true)
        val postEntity = PostEntity(
            id = postModel.id,
            text = postModel.text,
            isLiked = postModel.isLiked
        )
        coEvery { postDataSource.getAllPosts() } returns listOf(postEntity)

        val actual = repository.getAllPosts()

        val expected = listOf(postModel)

        assertEquals(expected, actual)
    }
}
