package com.example.fakestore.ui.data.network

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fakestore.ui.data.network.model.LoginDto
import com.example.fakestore.ui.data.preference.Preference
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.FakeStoreError
import javax.inject.Inject

class CommonNetworkDatasource @Inject constructor(
    private val fakeStoreAPIService: FakeStoreAPIService,
) : NetworkDatasource {

    override suspend fun login(email: MutableState<TextFieldValue>, password: MutableState<TextFieldValue>): Either<FakeStoreError, LoginDto> {
        return try {
            val loginDto = LoginDto(email.value.text, password.value.text)
            Either.Right(fakeStoreAPIService.login(loginDto).body()!!.toModel())
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

}