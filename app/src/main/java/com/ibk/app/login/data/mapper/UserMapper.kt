package com.ibk.app.login.data.mapper

import com.ibk.app.database.dto.UserEntity
import com.ibk.app.login.data.datasource.dto.UserLocalDto
import com.ibk.app.login.domain.model.User

fun UserLocalDto.convertToModel() = User(
    name = userName
)

fun UserEntity.convertToLocal() = UserLocalDto(
    id = id,
    userName = name,
    password = password
)