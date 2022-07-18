package com.ibk.app.login.data.repository

import com.ibk.app.login.data.datasource.UserDataSourceLocal
import com.ibk.app.login.data.datasource.dto.UserRequestDto
import com.ibk.app.login.data.mapper.convertToModel
import com.ibk.app.login.domain.model.User
import javax.inject.Inject


class UserRepository @Inject constructor(private val localDataSource: UserDataSourceLocal) {

    suspend fun login(userRequestDto: UserRequestDto): User {
        return localDataSource.login(userRequestDto).convertToModel()
    }

}