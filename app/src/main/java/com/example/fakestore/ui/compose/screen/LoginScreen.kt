package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.fakestore.ui.compose.components.LoginForm
import com.example.fakestore.ui.compose.components.LoginHeader
import com.example.fakestore.ui.compose.theme.on_tertiary
import com.example.fakestore.ui.compose.theme.tertiary
import com.example.fakestore.ui.compose.theme.tertiary_container
import com.example.fakestore.ui.viewmodel.LoginEvent
import com.example.fakestore.ui.viewmodel.LoginState

@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit,
) {

    val verticalGradientBackground = Brush.verticalGradient(
        colors = listOf(
            tertiary_container, on_tertiary, tertiary
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(verticalGradientBackground)
    ) {
        LoginHeader()
        LoginForm(
            state = state,
            onEvent = onEvent
        )
    }
    
}