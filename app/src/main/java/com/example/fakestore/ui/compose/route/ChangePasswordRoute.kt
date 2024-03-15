package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.ChangePasswordScreen
import com.example.fakestore.ui.viewmodel.ChangePasswordEvent
import com.example.fakestore.ui.viewmodel.ChangePasswordViewModel

@Composable
fun ChangePasswordRoute(
    userId: String,
    navController: NavController,
    viewModel: ChangePasswordViewModel = hiltViewModel()
) {
    viewModel.onEvent(ChangePasswordEvent.UserId(userId = userId), navController = navController)
    ChangePasswordScreen(
        state = viewModel.state.collectAsState().value
    ) { viewModel.onEvent(it, navController = navController) }
}