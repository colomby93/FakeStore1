package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.fakestore.ui.compose.components.HeaderLogin
import com.example.fakestore.ui.compose.components.Login
import com.example.fakestore.ui.compose.theme.on_tertiary
import com.example.fakestore.ui.compose.theme.tertiary
import com.example.fakestore.ui.compose.theme.tertiary_container

@Composable
fun LoginScreenCompose(onLoginClicked: (String, String) -> Unit) {

    val linear = Brush.verticalGradient(
        colors = listOf(
            tertiary,
            on_tertiary,
            tertiary_container
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(linear)
    ) {
        HeaderLogin()
        Login(onLoginClicked = onLoginClicked)
    }
}