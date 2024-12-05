package com.programming.study.architecturesexample.presentation.mvvm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MvvmViewModel @Inject constructor() : ViewModel() {

    fun test() = "This is a MVVM test"
}
