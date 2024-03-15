package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.compose.components.changePassword.ChangePasswordContent
import com.example.fakestore.ui.viewmodel.ChangePasswordEvent
import com.example.fakestore.ui.viewmodel.ChangePasswordViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePasswordScreen(
    state: ChangePasswordViewModel.ChangePasswordState,
    onEvent: (ChangePasswordEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = { onEvent(ChangePasswordEvent.OnArrowBackClicked) }, content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back icon"
                    )
                })
            }, title = { Text(text = "Change password", fontWeight = FontWeight.Bold) })
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp)
            ) {
                HorizontalDivider(color = Color.LightGray)
                Spacer(modifier = Modifier.height(40.dp))
                ChangePasswordContent(onEvent = onEvent, state = state)
            }
        }
    )
}


@Preview
@Composable
fun ChangePasswordScreen() {
    ChangePasswordScreen(
        state = ChangePasswordViewModel.ChangePasswordState(),
        {})
}