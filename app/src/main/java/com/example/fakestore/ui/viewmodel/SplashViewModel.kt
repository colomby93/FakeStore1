package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkConnectivityService
import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkStatus
import com.example.fakestore.ui.data.preference.Preferences
import com.example.fakestore.ui.navigation.Screen
import com.example.fakestore.ui.navigation.navigate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val preferences: Preferences,
    private val networkConnectivityService: NetworkConnectivityService
) : ViewModel() {

    private val _state = MutableStateFlow(SplashState())
    val state: StateFlow<SplashState> = _state

    private val token = preferences.hasToken()

    val networkStatus: StateFlow<NetworkStatus> = networkConnectivityService.networkStatus.stateIn(
        initialValue = NetworkStatus.Unknown,
        scope = viewModelScope,
        started = WhileSubscribed(5000)
    )

    init {
        token()
    }

    private fun token() {
        Log.e("token", "$token")
        if (token) {
            _state.update { it.copy(hasToken = true) }
        } else {
            _state.update { it.copy(hasToken = false) }
        }
    }

    fun onEvent(splashEvent: SplashEvent, navController: NavController) {
        when (splashEvent) {
            SplashEvent.NavigationToLoginScreen -> navigationToLoginScreen(navController = navController)
            SplashEvent.NavigationToMainScreen -> navigationToMainScreen(navController = navController)
            SplashEvent.NavigationToFailConnectionScreen -> navigationToFailConnectionScreen(
                navController = navController
            )
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

    private fun navigationToFailConnectionScreen(navController: NavController) {
        navController.navigate(Screen.FailConnection)
    }

    data class SplashState(
        val hasToken: Boolean = false
    )
}

sealed class SplashEvent {
    data object NavigationToMainScreen : SplashEvent()
    data object NavigationToLoginScreen : SplashEvent()
    data object NavigationToFailConnectionScreen : SplashEvent()
}