package com.ibk.app.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ibk.app.core.HandlerSession
import com.ibk.app.databinding.ActivityLoginBinding
import com.ibk.app.login.domain.model.User
import com.ibk.app.product.ui.AccountActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private val viewState = Observer<LoginViewState> { state ->
        when (state) {
            is LoginViewState.SuccessLogin -> setSuccessInUi(state.user)
            is LoginViewState.Failure -> setErrorInUi(state.failure)
        }
    }

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

    }

    private fun initViewModel() {
        binding.viewModel = viewModel
        viewModel.viewState.observe(this, viewState)
    }

    private fun setErrorInUi(failure: Throwable) {
        Toast.makeText(this, failure.message, Toast.LENGTH_SHORT).show()
    }

    private fun setSuccessInUi(user: User) {
        Toast.makeText(this, "Bienvenido ${user.name}", Toast.LENGTH_SHORT).show()
        HandlerSession.stateActiveSession()
        startActivity(Intent(this, AccountActivity::class.java))
        finish()
    }

}