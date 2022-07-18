package com.ibk.app.login.di

import com.ibk.app.database.AppDataBase
import com.ibk.app.login.data.datasource.UserDataSourceLocal
import com.ibk.app.login.data.datasource.UserDataSourceLocalImpl
import com.ibk.app.login.data.repository.UserRepository
import com.ibk.app.login.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Provides
    fun userDataSourceModule(appDataBase: AppDataBase): UserDataSourceLocal = UserDataSourceLocalImpl(appDataBase)

    @Provides
    fun userRepositoryModule(impl: UserDataSourceLocal) = UserRepository(impl)

    @Provides
    fun loginUserCaseModule(impl: UserRepository) = LoginUseCase(impl)
}