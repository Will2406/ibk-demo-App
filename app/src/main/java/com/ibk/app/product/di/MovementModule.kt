package com.ibk.app.product.di

import com.ibk.app.database.AppDataBase

import com.ibk.app.product.data.datasource.AccountDataSourceLocal
import com.ibk.app.product.data.datasource.AccountDataSourceLocalImpl
import com.ibk.app.product.data.datasource.MovementDataSourceLocal
import com.ibk.app.product.data.datasource.MovementDataSourceLocalImpl
import com.ibk.app.product.data.repository.AccountRepository
import com.ibk.app.product.data.repository.MovementRepository
import com.ibk.app.product.domain.usecase.GetAccounts
import com.ibk.app.product.domain.usecase.GetMovements
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MovementModule {

    @Provides
    fun movementDataSourceModule(appDataBase: AppDataBase): MovementDataSourceLocal =
        MovementDataSourceLocalImpl(appDataBase)

    @Provides
    fun movementRepositoryModule(impl: MovementDataSourceLocal) = MovementRepository(impl)

    @Provides
    fun getMovementsUserCaseModule(impl: MovementRepository) = GetMovements(impl)
}