package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.SplashScreen
import com.example.fakestore.ui.viewmodel.SplashViewModel

@Composable
fun SplashRoute(viewModel: SplashViewModel = hiltViewModel(), navController: NavController) {
    val token = viewModel.state.value.hasToken
    SplashScreen(token = token) { viewModel.onEvent(it, navController = navController) }
}