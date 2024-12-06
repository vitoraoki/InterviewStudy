package com.programming.study.architecturesexample.presentation.mvvm

import com.programming.study.architecturesexample.domain.model.InsertPostModel
import com.programming.study.architecturesexample.domain.model.PostModel
import com.programming.study.architecturesexample.domain.usecase.DeleteAllPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.GetAllPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.InsertPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.UpdatePostUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MvvmViewModelTest {

    private val getAllPostsUseCase: GetAllPostsUseCase = mockk()
    private val insertPostsUseCase: InsertPostsUseCase = mockk()
    private val deleteAllPostsUseCase: DeleteAllPostsUseCase = mockk()
    private val updatePostUseCase: UpdatePostUseCase = mockk()

    private lateinit var viewModel: MvvmViewModel

    private val postModel = PostModel(id = 0, text = "text", isLiked = true)
    private val postsList: List<PostModel> = listOf(postModel)

    @Before
    fun setup() {
        coEvery { getAllPostsUseCase() } returns postsList
        coEvery { insertPostsUseCase(any()) } just runs
        coEvery { deleteAllPostsUseCase() } just runs
        coEvery { updatePostUseCase(any()) } just runs

        viewModel = MvvmViewModel(
            getAllPostsUseCase,
            insertPostsUseCase,
            deleteAllPostsUseCase,
            updatePostUseCase
        )
    }

    @Test
    fun `init verify getAllPostsUseCase call`() = runTest {
        coVerify(exactly = 1) {
            getAllPostsUseCase()
        }
    }

    @Test
    fun `init assert posts as list of PostModel`() = runTest {
        assertEquals(postsList, viewModel.posts.value)
    }

    @Test
    fun `init assert isDeleteButtonEnabled as Boolean`() = runTest {
        assertEquals(true, viewModel.isDeleteButtonEnabled.value)
    }

    @Test
    fun `createPost verify insertPostsUseCase call`() = runTest {
        viewModel.createPost()

        val expected = InsertPostModel(text = "Post")

        coVerify(exactly = 1) {
            insertPostsUseCase(listOf(expected))
        }
    }

    @Test
    fun `createPost verify getAllPostsUseCase call`() = runTest {
        viewModel.createPost()

        coVerify(exactly = 2) {
            getAllPostsUseCase()
        }
    }

    @Test
    fun `deleteAllPosts verify deleteAllPostsUseCase call`() = runTest {
        viewModel.deleteAllPosts()

        coVerify(exactly = 1) {
            deleteAllPostsUseCase()
        }
    }

    @Test
    fun `deleteAllPosts verify getAllPostsUseCase call`() = runTest {
        viewModel.deleteAllPosts()

        coVerify(exactly = 2) {
            getAllPostsUseCase()
        }
    }

    @Test
    fun `likePost verify updatePostUseCase call`() = runTest {
        viewModel.likePost(postModel)

        val expected = postModel.copy(isLiked = !postModel.isLiked)

        coVerify(exactly = 1) {
            updatePostUseCase(post = expected)
        }
    }

    @Test
    fun `likePost getAllPostsUseCase call`() = runTest {
        viewModel.likePost(postModel)

        coVerify(exactly = 2) {
            getAllPostsUseCase()
        }
    }
}
