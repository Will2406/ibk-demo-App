package com.ibk.app.product.data.datasource

import com.ibk.app.product.data.datasource.dto.AccountLocalDto

interface AccountDataSourceLocal {
    suspend fun getAccounts(): List<AccountLocalDto>
    suspend fun updateAccounts(): List<AccountLocalDto>
}