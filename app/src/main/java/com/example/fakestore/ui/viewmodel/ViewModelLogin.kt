package com.example.fakestore.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.ui.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ViewModelLogin @Inject constructor(private val repository: Repository) : ViewModel() {

    data class UiState(
        val loading: Boolean = false,
        val email: String = "",
        val password: String = ""
    )

    private val _state = MutableStateFlow(UiState())
    var state: StateFlow<UiState> = _state

    private lateinit var email: MutableStateFlow<TextFieldValue>
    private lateinit var password: MutableStateFlow<TextFieldValue>

    fun authLogin(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.login(email, password).fold(
                    error = {},
                    success = {

                    }
                )
            }
        }
    }


    fun onLoginClicked(
        email: MutableState<TextFieldValue>,
        password: MutableState<TextFieldValue>
    ) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.login(email, password)
            }
        }
    }


}