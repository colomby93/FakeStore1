package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.EditEmailScreen
import com.example.fakestore.ui.viewmodel.EditEmailEvent
import com.example.fakestore.ui.viewmodel.EditEmailViewModel

@Composable
fun EditEmailRoute(
    userId: String,
    viewModel: EditEmailViewModel = hiltViewModel(),
    navController: NavController
) {
    viewModel.onEvent(EditEmailEvent.UserId(userId = userId), navController = navController)
    val userProfile by viewModel.state.collectAsState()
    userProfile.userProfile?.let { userProfile ->
        EditEmailScreen(
            userProfile = userProfile,
            state = viewModel.state.collectAsState().value
        ) { viewModel.onEvent(it, navController = navController) }
    }
}