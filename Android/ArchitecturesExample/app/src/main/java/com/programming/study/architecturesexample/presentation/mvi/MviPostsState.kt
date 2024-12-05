package com.programming.study.architecturesexample.presentation.mvi

import com.programming.study.architecturesexample.domain.model.PostModel

data class MviPostsState(
    val posts: List<PostModel> = listOf(),
    val isDeleteButtonEnabled: Boolean = false
)
