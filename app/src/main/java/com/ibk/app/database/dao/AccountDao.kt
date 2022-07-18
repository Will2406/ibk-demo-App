package com.ibk.app.database.dao

import androidx.room.*
import com.ibk.app.database.dto.AccountEntity


@Dao
interface AccountDao {


    @Query("SELECT * FROM Account")
    fun getAccounts(): List<AccountEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialData(accounts: List<AccountEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(accounts: AccountEntity)

    @Transaction
    suspend fun insertNewAccount(account: AccountEntity): List<AccountEntity> {
        insert(account)
        return getAccounts()
    }

}