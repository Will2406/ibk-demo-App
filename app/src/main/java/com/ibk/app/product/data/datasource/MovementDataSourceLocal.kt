package com.ibk.app.product.data.datasource

import com.ibk.app.database.dto.MovementEntity
import com.ibk.app.product.data.datasource.dto.MovementLocalDto

interface MovementDataSourceLocal {
    suspend fun getMovements(id: Int): List<MovementLocalDto>
}