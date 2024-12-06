package com.programming.study.architecturesexample.presentation.mvvm

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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MvvmViewModel @Inject constructor(
    private val getAllPostsUseCase: GetAllPostsUseCase,
    private val insertPostsUseCase: InsertPostsUseCase,
    private val deleteAllPostsUseCase: DeleteAllPostsUseCase,
    private val updatePostUseCase: UpdatePostUseCase
) : ViewModel() {

    private val _posts: MutableStateFlow<List<PostModel>> = MutableStateFlow(listOf())
    val posts: StateFlow<List<PostModel>> = _posts

    private val _isDeleteButtonEnabled: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isDeleteButtonEnabled: StateFlow<Boolean> = _isDeleteButtonEnabled

    init {
        updateState()
    }

    fun createPost() {
        viewModelScope.launch(Dispatchers.IO) {
            val insertPostModel = InsertPostModel(text = "Post")
            insertPostsUseCase(listOf(insertPostModel))
            updateState()
        }
    }

    fun deleteAllPosts() {
        viewModelScope.launch(Dispatchers.IO) {
            deleteAllPostsUseCase()
            updateState()
        }
    }

    fun likePost(postModel: PostModel) {
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
            _posts.value = posts
            _isDeleteButtonEnabled.value = posts.isNotEmpty()
        }
    }
}
