package com.programming.study.architecturesexample.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programming.study.architecturesexample.R
import com.programming.study.architecturesexample.domain.model.PostModel
import com.programming.study.architecturesexample.ui.theme.ArchitecturesExampleTheme

@Composable
fun PostItem(
    post: PostModel,
    onLikeClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = post.text,
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ,
            onClick = onLikeClick
        ) {
            Image(
                painter = painterResource(getLikeResource(post.isLiked)),
                contentDescription = null
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
            ,
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}

private fun getLikeResource(isLiked: Boolean) = if (isLiked) {
    R.drawable.thumbs_up_filled
} else {
    R.drawable.thumbs_up_lined
}

@Preview(showBackground = true)
@Composable
private fun PostItemPreview() {
    ArchitecturesExampleTheme {
        PostItem(
            post = PostModel(
                id = 1,
                text = "kldjskfljkdskfljkldsjklldsfkldjsklfjaklsldkjfldklsjlafjl;dskflkdsl;kfadlskfl;dskfl;kdsl;kf;kffjkldsajklfjdklsfjjdkslfds",
                isLiked = false
            ),
            onLikeClick = {}
        )
    }
}
