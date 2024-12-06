package com.programming.study.architecturesexample.presentation.mvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.programming.study.architecturesexample.domain.model.PostModel
import com.programming.study.architecturesexample.presentation.components.Header
import com.programming.study.architecturesexample.presentation.components.PostItem
import com.programming.study.architecturesexample.ui.theme.ArchitecturesExampleTheme

@Composable
fun MvvmScreenRoot(
    viewModel: MvvmViewModel = viewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MvvmScreen(
            modifier = Modifier.padding(innerPadding),
            posts = viewModel.posts.collectAsState().value,
            isDeleteButtonEnabled = viewModel.isDeleteButtonEnabled.collectAsState().value,
            createPost = viewModel::createPost,
            deleteAllPosts = viewModel::deleteAllPosts,
            likePost = viewModel::likePost
        )
    }
}

@Composable
private fun MvvmScreen(
    modifier: Modifier,
    posts: List<PostModel>,
    isDeleteButtonEnabled: Boolean,
    createPost: () -> Unit,
    deleteAllPosts: () -> Unit,
    likePost: (PostModel) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Header("MVVM")
        Buttons(isDeleteButtonEnabled, createPost, deleteAllPosts)
        PostsList(posts, likePost)
    }
}

@Composable
private fun Buttons(
    isDeleteButtonEnabled: Boolean,
    createPost: () -> Unit,
    deleteAllPosts: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = createPost
        ) {
            Text("Create Post")
        }

        Button(
            modifier = Modifier.weight(1f),
            enabled = isDeleteButtonEnabled,
            onClick = deleteAllPosts
        ) {
            Text("Delete all Posts")
        }
    }
}

@Composable
private fun PostsList(
    posts: List<PostModel>,
    likePost: (PostModel) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(posts) { post ->
            PostItem(post) {
                likePost(post)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MvvmScreenPreview() {
    ArchitecturesExampleTheme {
        MvvmScreen(
            modifier = Modifier,
            posts = listOf(
                PostModel(id = 1, text = "Post1", isLiked = false),
                PostModel(id = 2, text = "Post2", isLiked = true),
                PostModel(id = 3, text = "Post3", isLiked = true)
            ),
            isDeleteButtonEnabled = false,
            createPost = {},
            deleteAllPosts = {},
            likePost = {}
        )
    }
}
