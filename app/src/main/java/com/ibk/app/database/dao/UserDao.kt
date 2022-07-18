package com.ibk.app.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ibk.app.database.dto.UserEntity
import com.ibk.app.login.data.datasource.dto.UserLocalDto
import com.ibk.app.login.data.datasource.dto.UserRequestDto

@Dao
interface UserDao {

    @Query("SELECT * FROM user where user_name = :userName and password = :password")
    suspend fun searchUser(userName: String, password: String): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialData(user: UserEntity)
}