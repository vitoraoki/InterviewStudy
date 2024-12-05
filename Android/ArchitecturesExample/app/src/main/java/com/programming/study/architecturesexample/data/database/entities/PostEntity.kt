package com.programming.study.architecturesexample.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val POST_TABLE_NAME = "post_table"
const val COLUMN_TEXT = "text"
const val COLUMN_IS_LIKED = "is_liked"

@Entity(tableName = POST_TABLE_NAME)
data class PostEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(COLUMN_TEXT) val text: String,
    @ColumnInfo(COLUMN_IS_LIKED) val isLiked: Boolean
)
