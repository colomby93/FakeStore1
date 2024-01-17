package com.example.fakestore.ui.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Success

interface Repository {
    suspend fun login(email: MutableState<TextFieldValue>, password: MutableState<TextFieldValue>): Either<FakeStoreError, Success>
}