package com.programming.study.architecturesexample.presentation.mvi

import com.programming.study.architecturesexample.domain.model.PostModel

sealed class MviPostsAction {
    data object CreatePost: MviPostsAction()
    data object DeleteAllPosts: MviPostsAction()

    data class LikePost(
        val post: PostModel
    ): MviPostsAction()
}
