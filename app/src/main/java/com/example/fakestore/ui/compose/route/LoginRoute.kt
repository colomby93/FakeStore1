package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fakestore.ui.compose.screen.LoginScreenCompose
import com.example.fakestore.ui.viewmodel.ViewModelLogin

@Composable
fun LoginRoute(viewModelLogin: ViewModelLogin) {
    val email: MutableState<TextFieldValue>
    val password: MutableState<TextFieldValue>

    LoginScreenCompose(onLoginClicked = {viewModelLogin.authLogin(email.value.text, password.value.text)})
}