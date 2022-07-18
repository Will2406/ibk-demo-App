package com.ibk.app.product.data.datasource

import com.ibk.app.database.AppDataBase
import com.ibk.app.database.dto.AccountEntity
import com.ibk.app.product.data.datasource.dto.AccountLocalDto
import com.ibk.app.product.data.mapper.convertToLocal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountDataSourceLocalImpl @Inject constructor(private val database: AppDataBase) : AccountDataSourceLocal {

    private val accountDao = database.accountDao()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val accounts = mutableListOf<AccountEntity>()
            accounts.add(AccountEntity(1, "Dólares", "$ 15 000", "5854152651254789"))
            accounts.add(AccountEntity(2, "Dólares", "$ 12 454", "8749515263584975"))
            accounts.add(AccountEntity(3, "Soles", "S/ 5 622", "7485965124578512"))

            accountDao.insertInitialData(accounts)
        }
    }

    override suspend fun getAccounts(): List<AccountLocalDto> {
        return accountDao.getAccounts().convertToLocal()
    }

    override suspend fun updateAccounts(): List<AccountLocalDto> {
        val account = AccountEntity(4, "Soles", "S/ 1 452", "5471563125584444")
        return accountDao.insertNewAccount(account).convertToLocal()
    }

}