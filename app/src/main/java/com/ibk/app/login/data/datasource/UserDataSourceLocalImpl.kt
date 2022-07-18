package com.ibk.app.login.data.datasource

import com.ibk.app.database.AppDataBase
import com.ibk.app.database.dto.UserEntity
import com.ibk.app.login.data.datasource.dto.UserLocalDto
import com.ibk.app.login.data.datasource.dto.UserRequestDto
import com.ibk.app.login.data.mapper.convertToLocal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class UserDataSourceLocalImpl @Inject constructor(private val database: AppDataBase) : UserDataSourceLocal {

    private val userDao = database.userDao()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insertInitialData(UserEntity(id = 1, name = "Daniel", password = "Daniel"))
        }
    }

    override suspend fun login(user: UserRequestDto): UserLocalDto {
        return userDao.searchUser(user.name, user.password)?.convertToLocal()
            ?: throw Exception("Usuario y/o contraseña incorrectos")
    }
}