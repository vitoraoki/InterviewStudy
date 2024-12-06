package com.programming.study.architecturesexample.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.programming.study.architecturesexample.ui.theme.ArchitecturesExampleTheme

@Composable
fun Header(architectureName: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = architectureName)
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
            ,
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    ArchitecturesExampleTheme {
        Header(architectureName = "MVVM")
    }
}
