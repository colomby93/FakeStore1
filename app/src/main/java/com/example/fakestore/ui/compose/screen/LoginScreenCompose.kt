package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.fakestore.ui.compose.components.LoginForm
import com.example.fakestore.ui.compose.components.LoginHeader
import com.example.fakestore.ui.compose.theme.on_tertiary
import com.example.fakestore.ui.compose.theme.tertiary
import com.example.fakestore.ui.compose.theme.tertiary_container

@Composable
fun LoginScreenCompose(
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    isErrorLogin: Boolean
) {

    val verticalGradientBackground = Brush.verticalGradient(
        colors = listOf(
            tertiary_container,
            on_tertiary,
            tertiary
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .background(verticalGradientBackground)
    ) {
        LoginHeader()
        LoginForm(
            onEmailChanged = onEmailChanged,
            onPasswordChanged = onPasswordChanged,
            onLoginClicked = onLoginClicked,
            isErrorLogin = isErrorLogin,
        )
    }
}