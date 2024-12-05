package com.programming.study.architecturesexample.di

import com.programming.study.architecturesexample.domain.usecase.DeleteAllPosts
import com.programming.study.architecturesexample.domain.usecase.DeleteAllPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.DeletePost
import com.programming.study.architecturesexample.domain.usecase.DeletePostUseCase
import com.programming.study.architecturesexample.domain.usecase.GetAllPosts
import com.programming.study.architecturesexample.domain.usecase.GetAllPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.InsertPosts
import com.programming.study.architecturesexample.domain.usecase.InsertPostsUseCase
import com.programming.study.architecturesexample.domain.usecase.UpdatePost
import com.programming.study.architecturesexample.domain.usecase.UpdatePostUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsInsertPostsUseCase(useCase: InsertPosts): InsertPostsUseCase

    @Binds
    abstract fun bindsDeletePostUseCase(useCase: DeletePost): DeletePostUseCase

    @Binds
    abstract fun bindsDeleteAllPostsUseCase(useCase: DeleteAllPosts): DeletePostUseCase

    @Binds
    abstract fun bindsUpdatePostUseCase(useCase: UpdatePost): UpdatePostUseCase

    @Binds
    abstract fun bindsGetAllPostsUseCase(useCase: GetAllPosts): GetAllPostsUseCase
}
