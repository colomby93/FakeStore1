package com.example.fakestore.ui.compose.components.user

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.fakestore.ui.domain.model.UserProfile
import com.example.fakestore.ui.viewmodel.UserProfileEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInformationScreen(userProfile: UserProfile, onEvent: (UserProfileEvent) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = { onEvent(UserProfileEvent.OnArrowBackClicked) }, content = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow back icon"
                )
            })
        }, title = { Text(text = "personal information") })
    }, content = {
        UserInformationContent(it, userProfile, onEvent = onEvent)
    })
}

@Preview
@Composable
private fun AvatarUserPreview() {
    UserInformationScreen(
        UserProfile(
            "https://i.imgur.com/LDOO4Qs.jpg", "jhonatan@sss.com", 1, "Jose", "Password", "user"
        ), {}
    )
}