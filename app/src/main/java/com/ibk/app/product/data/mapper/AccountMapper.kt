package com.ibk.app.product.data.mapper


import com.ibk.app.database.dto.AccountEntity
import com.ibk.app.product.data.datasource.dto.AccountLocalDto
import com.ibk.app.product.domain.model.Account

/*fun AccountWithMovements.convertToLocal() = AccountLocalDto(
    type = account.type,
    amount = account.amount,
    number = account.number,
    movements = movements.convertToLocal()
)

fun List<AccountWithMovements>.convertToLocal() = map(AccountWithMovements::convertToLocal)*/

fun AccountEntity.convertToLocal() = AccountLocalDto(
    id = id ,
    type = type,
    amount = amount,
    number = number
)

fun List<AccountEntity>.convertToLocal() = map(AccountEntity::convertToLocal)

fun AccountLocalDto.convertToModel() = Account(
    id = id,
    type = getDisplayAccount(),
    amount = amount,
    number = number
)

fun List<AccountLocalDto>.convertToModel() = map(AccountLocalDto::convertToModel)
