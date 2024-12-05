package com.programming.study.architecturesexample.presentation.mvi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programming.study.architecturesexample.domain.model.InsertPostModel
import com.programming.study.architecturesexample.domain.model.PostModel
import com.programming.study.architecturesexample.domain.usecase.DeleteAllPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.GetAllPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.InsertPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.UpdatePostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MviPostsViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val insertPostsUseCase: InsertPostsUseCase,
    private val deleteAllPostsUseCase: DeleteAllPostsUseCase,
    private val updatePostUseCase: UpdatePostUseCase
): ViewModel() {

    var state by mutableStateOf(MviPostsState())
        private set

    init {
        updateState()
    }

    fun executeActions(action: MviPostsAction) {
        when (action) {
            MviPostsAction.CreatePost -> createPost()
            MviPostsAction.DeleteAllPosts -> deleteAllPosts()
            is MviPostsAction.LikePost -> likePost(action.post)
        }
    }

    private fun createPost() {
        viewModelScope.launch(Dispatchers.IO) {
            val insertPostModel = InsertPostModel(text = "Post")
            insertPostsUseCase(listOf(insertPostModel))
            updateState()
        }
    }

    private fun deleteAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllPostsUseCase()
            updateState()
        }
    }

    private fun likePost(postModel: PostModel) {
        viewModelScope.launch(Dispatchers.IO) {
            updatePostUseCase(
                post = postModel.copy(isLiked = !postModel.isLiked)
            )
            updateState()
        }
    }

    private fun updateState() {
        viewModelScope.launch(Dispatchers.IO) {
            val posts = getAllPostsUseCase()
            state = state.copy(
                posts = posts,
                isDeleteButtonEnabled = posts.isNotEmpty()
            )
        }
    }
}
