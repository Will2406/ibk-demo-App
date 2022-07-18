package com.ibk.app.product.domain.usecase

import com.ibk.app.product.data.repository.AccountRepository
import com.ibk.app.product.data.repository.MovementRepository
import com.ibk.app.product.domain.model.Account
import com.ibk.app.product.domain.model.Movement
import javax.inject.Inject

class GetMovements @Inject constructor(private val repository: MovementRepository) {

    suspend operator fun invoke(id: Int): List<Movement> {
        return repository.getMovements(id)
    }
}