package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.screen.LoginScreenCompose
import com.example.fakestore.ui.viewmodel.LoginViewModel

@Composable
fun LoginRoute(viewModel: LoginViewModel) {

    LoginScreenCompose(
        onEmailChanged = { viewModel.onEmailChanged(it) },
        onPasswordChanged = { viewModel.onPasswordChanged(it) },
        onLoginClicked = { viewModel.doLogin() })

}