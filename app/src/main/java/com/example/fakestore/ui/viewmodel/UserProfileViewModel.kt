package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.UserProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> = _state

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getUserProfile()
                    .fold(
                        error = { Log.e("Error user profile ", "Error network user profile") },
                        success = { userProfile ->
                            _state.update { it.copy(userProfile = userProfile, loading = false) }
                        }
                    )
            }
        }
    }

    data class UIState(
        val loading: Boolean = false,
        val userProfile: UserProfile? = null,
        val token: String = ""
    )
}

