package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.UserProfile
import com.example.fakestore.ui.navigation.Screen
import com.example.fakestore.ui.navigation.USER_ID
import com.example.fakestore.ui.navigation.navigate
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
    private val repository: Repository
) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> = _state

    init {
        getUserProfile()
    }

    fun onEvent(userProfileEvent: UserProfileEvent, navController: NavController) {
        when (userProfileEvent) {
            is UserProfileEvent.OnArrowBackClicked -> onArrowBack(navController = navController)
            is UserProfileEvent.OnClickedIconEditEmail -> navigateToScreenEditEmail(
                userId = userProfileEvent.userId,
                navController = navController
            )

            is UserProfileEvent.OnClickedIconChangePassword -> navigateToScreenChangePassword(
                userId = userProfileEvent.userId,
                navController = navController
            )
        }
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

    private fun onArrowBack(navController: NavController) {
        if (navController.previousBackStackEntry != null) {
            navController.navigateUp()
        }
    }

    private fun navigateToScreenEditEmail(userId: String, navController: NavController) {
        navController.navigate(screen = Screen.EditEmail, args = USER_ID to userId)
    }

    private fun navigateToScreenChangePassword(userId: String, navController: NavController) {
        navController.navigate(screen = Screen.ChangePassword, args = USER_ID to userId)
    }

    data class UIState(
        val loading: Boolean = false,
        val userProfile: UserProfile? = null,
        val token: String = ""
    )
}

sealed class UserProfileEvent {
    data object OnArrowBackClicked : UserProfileEvent()
    data class OnClickedIconEditEmail(val userId: String) : UserProfileEvent()
    data class OnClickedIconChangePassword(val userId: String) : UserProfileEvent()
}

