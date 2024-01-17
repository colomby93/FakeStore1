package com.example.fakestore.ui.data.network

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fakestore.ui.data.network.model.LoginDto
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.FakeStoreError

interface NetworkDatasource {
    suspend fun login(email: MutableState<TextFieldValue>, password: MutableState<TextFieldValue>): Either<FakeStoreError, LoginDto>
}