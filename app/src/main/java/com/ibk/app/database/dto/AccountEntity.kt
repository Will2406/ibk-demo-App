package com.ibk.app.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "type") var type: String,
    @ColumnInfo(name = "amount") var amount: String,
    @ColumnInfo(name = "number") var number: String
)