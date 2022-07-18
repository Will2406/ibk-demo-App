package com.ibk.app.database.dto

import androidx.room.Embedded
import androidx.room.Relation

data class AccountWithMovements(
    @Embedded val account: AccountEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "account_id"
    )
    val movements: List<MovementEntity>
)