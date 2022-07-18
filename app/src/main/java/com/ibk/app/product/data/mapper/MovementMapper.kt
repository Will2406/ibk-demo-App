package com.ibk.app.product.data.mapper

import com.ibk.app.database.dto.MovementEntity
import com.ibk.app.product.data.datasource.dto.MovementLocalDto
import com.ibk.app.product.domain.model.Movement

fun MovementEntity.convertToLocal() = MovementLocalDto(
    id = id,
    destination = destination,
    isMoneyIncome = isMoneyIncome,
    date = date,
    amount = amount
)

fun List<MovementEntity>.convertToLocal() = map(MovementEntity::convertToLocal)

fun MovementLocalDto.convertToModel() = Movement(
    id = id ,
    destination = destination,
    isMoneyIncome = isMoneyIncome,
    date = date,
    amount = amount
)

fun List<MovementLocalDto>.convertToModel() = map(MovementLocalDto::convertToModel)