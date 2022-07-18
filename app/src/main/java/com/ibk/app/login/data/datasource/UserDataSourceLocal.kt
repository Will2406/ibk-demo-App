package com.ibk.app.login.data.datasource

import com.ibk.app.login.data.datasource.dto.UserLocalDto
import com.ibk.app.login.data.datasource.dto.UserRequestDto

interface UserDataSourceLocal {
    suspend fun login(user: UserRequestDto): UserLocalDto
}