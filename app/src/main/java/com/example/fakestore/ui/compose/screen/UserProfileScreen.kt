package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.user.UserInformationScreen
import com.example.fakestore.ui.domain.model.UserProfile

@Composable
fun UserProfileScreen(userProfile: UserProfile) {
    UserInformationScreen(userProfile = userProfile)
}