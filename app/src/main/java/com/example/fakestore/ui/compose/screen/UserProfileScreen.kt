package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.userProfile.UserInformationScreen
import com.example.fakestore.ui.domain.model.UserProfile
import com.example.fakestore.ui.viewmodel.UserProfileEvent

@Composable
fun UserProfileScreen(userProfile: UserProfile, onEvent: (UserProfileEvent) -> Unit) {
    UserInformationScreen(userProfile = userProfile, onEvent = onEvent)
}