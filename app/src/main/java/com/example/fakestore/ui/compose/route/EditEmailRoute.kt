package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.screen.EditEmailScreen
import com.example.fakestore.ui.viewmodel.UserProfileViewModel

@Composable
fun EditEmailRoute(viewModel: UserProfileViewModel = hiltViewModel()) {
    val userProfile by viewModel.state.collectAsState()
    userProfile.userProfile?.let { userProfile ->
        EditEmailScreen(userProfile = userProfile)
    }
}