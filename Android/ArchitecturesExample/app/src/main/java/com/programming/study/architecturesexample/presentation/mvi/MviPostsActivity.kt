package com.programming.study.architecturesexample.presentation.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.programming.study.architecturesexample.ui.theme.ArchitecturesExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MviPostsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitecturesExampleTheme {
                MviPostsScreenRoot()
            }
        }
    }
}
