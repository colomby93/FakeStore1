package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.data.preference.Preferences
import com.example.fakestore.ui.navigation.Screen
import com.example.fakestore.ui.navigation.navigate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(preferences: Preferences) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    private val token = preferences.hasToken()

    init {
        token()
    }

    private fun token() {
        if (token) {
            Log.e("token", "$token")
            _state.update { it.copy(hasToken = true) }
        } else {
            _state.update { it.copy(hasToken = false) }
        }
    }

    fun onEvent(splashEvent: SplashEvent, navController: NavController) {
        when (splashEvent) {
            SplashEvent.NavigationToLoginScreen -> navigationToLoginScreen(navController = navController)
            SplashEvent.NavigationToMainScreen -> navigationToMainScreen(navController = navController)
        }
    }

    private fun navigationToMainScreen(navController: NavController) {
        navController.navigate(Screen.MainScreen) {
            popUpTo(route = Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    private fun navigationToLoginScreen(navController: NavController) {
        navController.navigate(Screen.Login) {
            popUpTo(route = Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    data class SplashState(
        val loading: Boolean = false,
        val hasToken: Boolean = false
    )
}

sealed class SplashEvent {
    data object NavigationToMainScreen : SplashEvent()
    data object NavigationToLoginScreen : SplashEvent()
}