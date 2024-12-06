package com.programming.study.architecturesexample.presentation.mvi

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
import com.programming.study.architecturesexample.presentation.components.PostItem
import com.programming.study.architecturesexample.ui.theme.ArchitecturesExampleTheme

@Composable
fun MviPostsScreenRoot(
    viewModel: MviPostsViewModel = viewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        MviPostsScreen(
            modifier = Modifier.padding(innerPadding),
            state = viewModel.state.collectAsState().value
        ) { action ->
            viewModel.executeActions(action)
        }
    }
}

@Composable
private fun MviPostsScreen(
    modifier: Modifier,
    state: MviPostsState,
    executeAction: (MviPostsAction) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Buttons(state.isDeleteButtonEnabled, executeAction)
        PostsList(state.posts, executeAction)
    }
}

@Composable
private fun Buttons(
    isDeleteButtonEnabled: Boolean,
    executeAction: (MviPostsAction) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = {
                executeAction(MviPostsAction.CreatePost)
            }
        ) {
            Text("Create Post")
        }

        Button(
            modifier = Modifier.weight(1f),
            enabled = isDeleteButtonEnabled,
            onClick = {
                executeAction(MviPostsAction.DeleteAllPosts)
            }
        ) {
            Text("Delete all Posts")
        }
    }
}

@Composable
private fun PostsList(
    posts: List<PostModel>,
    executeAction: (MviPostsAction) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(posts) { post ->
            PostItem(post) {
                executeAction(
                    MviPostsAction.LikePost(post)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposablePreview() {
    ArchitecturesExampleTheme {
        MviPostsScreen(
            modifier = Modifier,
            MviPostsState(
                posts = listOf(
                    PostModel(id = 1, text = "Post1", isLiked = false),
                    PostModel(id = 2, text = "Post2", isLiked = true),
                    PostModel(id = 3, text = "Post3", isLiked = true)
                ),
                isDeleteButtonEnabled = false
            ),
            {}
        )
    }
}
