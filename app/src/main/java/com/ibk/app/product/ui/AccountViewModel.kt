package com.ibk.app.product.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibk.app.core.safeLaunch
import com.ibk.app.product.domain.model.Account
import com.ibk.app.product.domain.model.Movement
import com.ibk.app.product.domain.usecase.GetAccounts
import com.ibk.app.product.domain.usecase.GetMovements
import com.ibk.app.product.domain.usecase.UpdateAccounts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getAccounts: GetAccounts,
    private val updateAccounts: UpdateAccounts,
    private val getMovements: GetMovements
) : ViewModel() {

    private val _accounts = MutableLiveData<List<Account>>()
    val accounts: LiveData<List<Account>> = _accounts

    private val _movements = MutableLiveData<List<Movement>>()
    val movements: LiveData<List<Movement>> = _movements

    init {
        getAllAccounts()
    }

    private fun getAllAccounts() {
        viewModelScope.safeLaunch {
            val response = withContext(Dispatchers.IO) { getAccounts.invoke() }
            _accounts.postValue(response)
        }
    }

    fun updateAccounts() {
        viewModelScope.safeLaunch {
            val response = withContext(Dispatchers.IO) { updateAccounts.invoke() }
            _accounts.postValue(response)
        }
    }

    fun getAllMovements(account: Account?) {
        viewModelScope.safeLaunch {
            val response = withContext(Dispatchers.IO) { getMovements.invoke(account?.id ?: 0) }
            _movements.postValue(response)
        }
    }

}