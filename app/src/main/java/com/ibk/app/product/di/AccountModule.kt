package com.ibk.app.product.di

import com.ibk.app.database.AppDataBase

import com.ibk.app.product.data.datasource.AccountDataSourceLocal
import com.ibk.app.product.data.datasource.AccountDataSourceLocalImpl
import com.ibk.app.product.data.repository.AccountRepository
import com.ibk.app.product.domain.usecase.GetAccounts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AccountModule {

    @Provides
    fun accountDataSourceModule(appDataBase: AppDataBase): AccountDataSourceLocal =
        AccountDataSourceLocalImpl(appDataBase)

    @Provides
    fun accountRepositoryModule(impl: AccountDataSourceLocal) = AccountRepository(impl)

    @Provides
    fun getAccountsUserCaseModule(impl: AccountRepository) = GetAccounts(impl)
}