package com.programming.study.architecturesexample.di

import com.programming.study.architecturesexample.data.datasource.PostDataSource
import com.programming.study.architecturesexample.data.datasource.PostLocalDataSource
import com.programming.study.architecturesexample.data.repository.PostRepository
import com.programming.study.architecturesexample.data.repository.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsPostDataSource(localDataSource: PostLocalDataSource): PostDataSource

    @Binds
    abstract fun bindsPostRepository(repository: PostRepositoryImpl): PostRepository
}
