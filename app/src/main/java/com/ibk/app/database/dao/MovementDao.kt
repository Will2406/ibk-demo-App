package com.ibk.app.database.dao

import androidx.room.*
import com.ibk.app.database.dto.MovementEntity

@Dao
interface MovementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInitialData(accounts: List<MovementEntity>)

    @Transaction
    @Query("SELECT * FROM Movement where account_id=:id ")
    fun getMovementsOfAccount(id: Int): List<MovementEntity>
}