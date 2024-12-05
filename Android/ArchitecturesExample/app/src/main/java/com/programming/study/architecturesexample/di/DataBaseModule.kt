package com.programming.study.architecturesexample.di

import android.content.Context
import androidx.room.Room
import com.programming.study.architecturesexample.data.database.DATABASE_NAME
import com.programming.study.architecturesexample.data.database.PostDatabase
import com.programming.study.architecturesexample.data.database.dao.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): PostDatabase =
        Room.databaseBuilder(
            context,
            PostDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun providesPostDao(database: PostDatabase): PostDao = database.postDao()
}
