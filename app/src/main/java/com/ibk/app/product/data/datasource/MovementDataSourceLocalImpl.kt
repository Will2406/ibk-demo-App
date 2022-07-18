package com.ibk.app.product.data.datasource

import com.ibk.app.database.AppDataBase
import com.ibk.app.database.dto.MovementEntity
import com.ibk.app.product.data.datasource.dto.MovementLocalDto
import com.ibk.app.product.data.mapper.convertToLocal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovementDataSourceLocalImpl @Inject constructor(private val database: AppDataBase) : MovementDataSourceLocal {

    private val movementDao = database.movementDao()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val movements = mutableListOf<MovementEntity>()
            movements.add(MovementEntity(1, "Transferencia", true, "25 de Marzo de 2022", "$ 500", 1))
            movements.add(MovementEntity(2, "PLIN", false, "28 de Marzo de 2022", "$ 800", 1))
            movements.add(MovementEntity(3, "Transferencia", true, "05 de Junio de 2022", "$ 1500", 1))
            movements.add(MovementEntity(4, "Transferencia", true, "2 de Junio de 2022", "$ 6000", 1))

            movementDao.insertInitialData(movements)
        }
    }

    override suspend fun getMovements(id: Int): List<MovementLocalDto> {
        return movementDao.getMovementsOfAccount(id).convertToLocal()
    }
}