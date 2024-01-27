package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.screen.LoginScreen
import com.example.fakestore.ui.viewmodel.LoginViewModel

@Composable
fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel()
) {
    
    LoginScreen(
        state = viewModel.state.collectAsState().value,
        onEvent = { viewModel.onEvent(it) },
    )

}