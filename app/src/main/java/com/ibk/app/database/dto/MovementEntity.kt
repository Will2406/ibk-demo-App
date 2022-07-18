package com.ibk.app.database.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Movement")
data class MovementEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "destination") var destination: String,
    @ColumnInfo(name = "is_money_income") var isMoneyIncome: Boolean,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "amount") var amount: String,
    @ColumnInfo(name = "account_id") val accountId: Long,
)