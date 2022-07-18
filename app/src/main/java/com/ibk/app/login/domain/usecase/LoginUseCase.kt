package com.ibk.app.login.domain.usecase

import com.ibk.app.login.data.datasource.dto.UserRequestDto
import com.ibk.app.login.data.repository.UserRepository
import com.ibk.app.login.domain.model.User
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: UserRepository) {

    suspend operator fun invoke(userRequestDto: UserRequestDto): User {
        return repository.login(userRequestDto)
    }
}