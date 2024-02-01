package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var email: String = ""
    private var password: String = ""
    private var onLogin: Boolean = false

    private val _state = MutableStateFlow(LoginState())
    var state: StateFlow<LoginState> = _state

    fun onEvent(loginEvent: LoginEvent, navController: NavController) {
        when (loginEvent) {
            is LoginEvent.OnEmailChanged -> onEmailChanged(loginEvent.newEmail)
            is LoginEvent.OnPasswordChanged -> onPasswordChanged(loginEvent.newPassword)
            LoginEvent.OnLoginClicked -> doLogin(navController = navController)
        }
    }

    private fun onEmailChanged(email: String) {
        this.email = email
    }

    private fun onPasswordChanged(password: String) {
        this.password = password
    }

    private fun doLogin(navController: NavController) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.login(email, password).fold(
                    error = {
                        Log.i("Error Login", "Ha fallado la petición")
                        _state.update { it.copy(showError = true) }
                    },
                    success = {
                        onLogin = true
                        _state.update { it.copy(loading = false) }
                    }
                )
            }
            onLogin(navController = navController)
        }
    }

    private fun onLogin(navController: NavController) {
        if (onLogin) {
            navController.navigate(Screen.MainScreen.route) {
                popUpTo(0) {
                    inclusive = true
                }
            }
        }

    }
}

data class LoginState(
    val loading: Boolean = false,
    val showError: Boolean = false,
)

sealed class LoginEvent {
    data class OnEmailChanged(val newEmail: String) : LoginEvent()
    data class OnPasswordChanged(val newPassword: String) : LoginEvent()
    data object OnLoginClicked : LoginEvent()
}