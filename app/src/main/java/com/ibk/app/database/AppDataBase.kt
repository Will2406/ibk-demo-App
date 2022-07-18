package com.ibk.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ibk.app.database.dao.AccountDao
import com.ibk.app.database.dao.MovementDao
import com.ibk.app.database.dao.UserDao
import com.ibk.app.database.dto.AccountEntity
import com.ibk.app.database.dto.AccountWithMovements
import com.ibk.app.database.dto.MovementEntity
import com.ibk.app.database.dto.UserEntity

@Database(
    entities = [UserEntity::class, AccountEntity::class, MovementEntity::class],
    version = AppDataBase.VERSION,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun accountDao(): AccountDao
    abstract fun movementDao(): MovementDao

    companion object {
        const val VERSION = 4
        const val NAME = "db_ibk_v$VERSION"
    }
}