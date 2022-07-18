package com.ibk.app.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "user_name") var name: String,
    @ColumnInfo(name = "password") var password: String
)
