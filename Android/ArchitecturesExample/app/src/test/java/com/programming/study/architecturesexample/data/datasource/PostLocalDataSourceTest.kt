package com.programming.study.architecturesexample.data.datasource

import com.programming.study.architecturesexample.data.database.dao.PostDao
import com.programming.study.architecturesexample.data.database.entities.PostEntity
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PostLocalDataSourceTest {

    private val postDao: PostDao = mockk()

    private val dataSource = PostLocalDataSource(postDao)

    init {
        every { postDao.insertPosts(any()) } just runs
        every { postDao.deletePost(any()) } just runs
        every { postDao.deleteAllPosts() } just runs
        every { postDao.updatePost(any()) } just runs
    }

    @Test
    fun `insertPosts verify insertPosts DAO call`() = runTest {
        val posts: List<PostEntity> = listOf(mockk())

        dataSource.insertPosts(posts)

        verify(exactly = 1) {
            postDao.insertPosts(posts)
        }
    }

    @Test
    fun `deletePost verify deletePost DAO call`() = runTest {
        val expected: PostEntity = mockk()

        dataSource.deletePost(expected)

        verify(exactly = 1) {
            postDao.deletePost(expected)
        }
    }

    @Test
    fun `deleteAllPosts verify deleteAllPosts DAO call`() = runTest {
        dataSource.deleteAllPosts()

        verify(exactly = 1) {
            postDao.deleteAllPosts()
        }
    }

    @Test
    fun `updatePost verify updatePost DAO call`() = runTest {
        val expected: PostEntity = mockk()

        dataSource.updatePost(expected)

        verify(exactly = 1) {
            postDao.updatePost(expected)
        }
    }

    @Test
    fun `getAllPosts verify getAllPosts DAO call`() = runTest {
        val expected: List<PostEntity> = listOf(mockk())
        every { postDao.getAllPosts() } returns expected

        postDao.getAllPosts()

        verify(exactly = 1) {
            postDao.getAllPosts()
        }
    }

    @Test
    fun `getAllPosts assert list of PostEntity`() = runTest {
        val expected: List<PostEntity> = listOf(mockk())
        every { postDao.getAllPosts() } returns expected

        val actual = postDao.getAllPosts()

        assertEquals(expected, actual)
    }
}
