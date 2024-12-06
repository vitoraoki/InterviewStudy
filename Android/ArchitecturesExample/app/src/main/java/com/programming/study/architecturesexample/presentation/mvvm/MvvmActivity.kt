package com.programming.study.architecturesexample.presentation.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.programming.study.architecturesexample.ui.theme.ArchitecturesExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MvvmActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitecturesExampleTheme(darkTheme = false) {
                MvvmScreenRoot()
            }
        }
    }
}
