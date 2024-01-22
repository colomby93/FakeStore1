@file:Suppress("UNUSED_EXPRESSION")

package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.LoginScreenCompose
import com.example.fakestore.ui.viewmodel.LoginViewModel

@Composable
fun LoginRoute(viewModel: LoginViewModel, navController: NavController) {

    LoginScreenCompose(
        onEmailChanged = {
            viewModel.onEmailChanged(it)
        },
        onPasswordChanged = {
            viewModel.onPasswordChanged(it)
        },
        onLoginClicked = {
            viewModel.doLogin(navController = navController)
        },
        isErrorLogin = viewModel.state.collectAsState().value.isErrorLogin
    )

}