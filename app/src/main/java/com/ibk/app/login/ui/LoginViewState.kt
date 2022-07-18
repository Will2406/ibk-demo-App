package com.ibk.app.login.ui

import com.ibk.app.login.domain.model.User

sealed class LoginViewState {
    data class Failure(val failure: Throwable) : LoginViewState()
    data class SuccessLogin(val user: User) : LoginViewState()
}