package com.ibk.app.product.domain.usecase

import com.ibk.app.product.data.repository.AccountRepository
import com.ibk.app.product.domain.model.Account
import javax.inject.Inject

class UpdateAccounts @Inject constructor(private val repository: AccountRepository) {

    suspend operator fun invoke(): List<Account> {
        return repository.updateAccounts()
    }
}