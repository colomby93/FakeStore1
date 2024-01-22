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
    private var errorLogin: Boolean = false

    data class UiState(
        val loading: Boolean = false,
        val isErrorLogin: Boolean = false,
    )

    private val _state = MutableStateFlow(UiState())
    var state: StateFlow<UiState> = _state

    fun onEmailChanged(email: String) {
        this.email = email
        Log.i("Changes: ", "Email: $email")
    }

    fun onPasswordChanged(password: String) {
        this.password = password
        Log.i("Changes: ", "Password: $password")
    }

    fun doLogin(navController: NavController) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.login(email, password).fold(
                    error = {
                        _state.update { it.copy(isErrorLogin = true) }
                    },
                    success = {
                        _state.update {
                            it.copy(loading = false)
                        }
                        errorLogin = true
                    }
                )
            }
            onLogin(navController)
        }

    }

    private fun onLogin(navController: NavController) {
        if (errorLogin){
            navController.navigate(Screen.FirstRoute.route){
                popUpTo(0){
                    inclusive = true
                }
            }
        }
    }

}

