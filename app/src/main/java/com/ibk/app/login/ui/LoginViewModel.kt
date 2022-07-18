package com.ibk.app.login.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibk.app.core.safeLaunch
import com.ibk.app.login.data.datasource.dto.UserRequestDto
import com.ibk.app.login.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val useCase: LoginUseCase) : ViewModel() {

    private val _viewState = MutableLiveData<LoginViewState>()
    val viewState: LiveData<LoginViewState> = _viewState

    var username: String = ""
    var password: String = ""

    fun login() {
        val userRequestDto = UserRequestDto(username, password)
        viewModelScope.safeLaunch(::exceptionHandler) {
            val response = withContext(Dispatchers.IO) { useCase(userRequestDto) }
            _viewState.postValue(LoginViewState.SuccessLogin(response))
        }
    }

    private fun exceptionHandler(failure: Throwable) {
        _viewState.postValue(LoginViewState.Failure(failure))
    }
}