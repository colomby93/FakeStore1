package com.example.fakestore.ui.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fakestore.ui.data.network.NetworkDatasource
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Login
import com.example.fakestore.ui.domain.model.Success
import javax.inject.Inject

class CommonRepository @Inject constructor(private val networkDatasource: NetworkDatasource) :
    Repository {

    override suspend fun login(email: MutableState<TextFieldValue>, password: MutableState<TextFieldValue>): Either<FakeStoreError, Success> {
        return networkDatasource.login(email, password).flatMap {
            print(it.success)
            Either.Right(Success)
        }
    }

}