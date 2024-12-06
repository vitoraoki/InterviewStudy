package com.programming.study.architecturesexample.presentation.mvi

import com.programming.study.architecturesexample.domain.model.PostModel

sealed class MviAction {

    data object CreatePost: MviAction()
    data object DeleteAllPosts: MviAction()

    data class LikePost(
        val post: PostModel
    ): MviAction()
}
