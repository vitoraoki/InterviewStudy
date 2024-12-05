package com.programming.study.architecturesexample.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.programming.study.architecturesexample.data.database.dao.PostDao
import com.programming.study.architecturesexample.data.database.entities.PostEntity

const val DATABASE_NAME = "post_database"
const val DATABASE_VERSION = 1

@Database(entities = [PostEntity::class], version = DATABASE_VERSION)
abstract class PostDatabase: RoomDatabase() {
    abstract fun postDao(): PostDao
}
