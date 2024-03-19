package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.FailConnectionScreen
import com.example.fakestore.ui.viewmodel.FailConnectionViewModel

@Composable
fun FailConnectionRoute(
    viewModel: FailConnectionViewModel = hiltViewModel(),
    navController: NavController
) {
    FailConnectionScreen() { viewModel.onEvent(it, navController = navController) }
}
