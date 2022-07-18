package com.ibk.app.product.data.repository

import com.ibk.app.product.data.datasource.AccountDataSourceLocal
import com.ibk.app.product.data.mapper.convertToModel
import com.ibk.app.product.domain.model.Account
import javax.inject.Inject

class AccountRepository @Inject constructor(private val localDataSource: AccountDataSourceLocal) {

    suspend fun getAccounts(): List<Account> {
        return localDataSource.getAccounts().convertToModel()
    }

    suspend fun updateAccounts(): List<Account> {
        return localDataSource.updateAccounts().convertToModel()
    }

}