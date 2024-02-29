package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.UserProfileScreen
import com.example.fakestore.ui.viewmodel.UserProfileViewModel

@Composable
fun UserProfileRoute(
    viewModel: UserProfileViewModel = hiltViewModel(), navController: NavController
) {
    val user by viewModel.state.collectAsState()
    user.userProfile?.let { userProfile ->
        UserProfileScreen(userProfile = userProfile)
    }
}