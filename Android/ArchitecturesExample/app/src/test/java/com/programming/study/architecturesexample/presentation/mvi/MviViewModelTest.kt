package com.programming.study.architecturesexample.presentation.mvi

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

class MviViewModelTest {

    private val getAllPostsUseCase: GetAllPostsUseCase = mockk()
    private val insertPostsUseCase: InsertPostsUseCase = mockk()
    private val deleteAllPostsUseCase: DeleteAllPostsUseCase = mockk()
    private val updatePostUseCase: UpdatePostUseCase = mockk()

    private lateinit var viewModel: MviViewModel

    private val postModel = PostModel(id = 0, text = "text", isLiked = true)
    private val postsList: List<PostModel> = listOf(postModel)

    @Before
    fun setup() {
        coEvery { getAllPostsUseCase() } returns postsList
        coEvery { insertPostsUseCase(any()) } just runs
        coEvery { deleteAllPostsUseCase() } just runs
        coEvery { updatePostUseCase(any()) } just runs

        viewModel = MviViewModel(
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
    fun `init assert state as MviState`() = runTest {
        val expected = MviState(posts = postsList, isDeleteButtonEnabled = true)

        assertEquals(expected, viewModel.state.value)
    }

    @Test
    fun `executeActions with CreatePost verify insertPostsUseCase call`() = runTest {
        viewModel.executeActions(MviAction.CreatePost)

        val expected = InsertPostModel(text = "Post")

        coVerify(exactly = 1) {
            insertPostsUseCase(listOf(expected))
        }
    }

    @Test
    fun `executeActions with CreatePost verify getAllPostsUseCase call`() = runTest {
        viewModel.executeActions(MviAction.CreatePost)

        coVerify(exactly = 2) {
            getAllPostsUseCase()
        }
    }

    @Test
    fun `executeActions with DeleteAllPosts verify deleteAllPostsUseCase call`() = runTest {
        viewModel.executeActions(MviAction.DeleteAllPosts)

        coVerify(exactly = 1) {
            deleteAllPostsUseCase()
        }
    }

    @Test
    fun `executeActions with DeleteAllPosts verify getAllPostsUseCase call`() = runTest {
        viewModel.executeActions(MviAction.DeleteAllPosts)

        coVerify(exactly = 2) {
            getAllPostsUseCase()
        }
    }

    @Test
    fun `executeActions with LikePost verify updatePostUseCase call`() = runTest {
        viewModel.executeActions(MviAction.LikePost(postModel))

        val expected = postModel.copy(isLiked = !postModel.isLiked)

        coVerify(exactly = 1) {
            updatePostUseCase(post = expected)
        }
    }

    @Test
    fun `executeActions with LikePost verify getAllPostsUseCase call`() = runTest {
        viewModel.executeActions(MviAction.LikePost(postModel))

        coVerify(exactly = 2) {
            getAllPostsUseCase()
        }
    }
}
