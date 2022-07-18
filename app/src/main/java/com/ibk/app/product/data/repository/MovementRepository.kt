package com.ibk.app.product.data.repository

import com.ibk.app.product.data.datasource.AccountDataSourceLocal
import com.ibk.app.product.data.datasource.MovementDataSourceLocal
import com.ibk.app.product.data.mapper.convertToModel
import com.ibk.app.product.domain.model.Movement
import javax.inject.Inject

class MovementRepository @Inject constructor(private val localDataSource: MovementDataSourceLocal) {

    suspend fun getMovements(id: Int): List<Movement> {
        return localDataSource.getMovements(id).convertToModel()
    }
}