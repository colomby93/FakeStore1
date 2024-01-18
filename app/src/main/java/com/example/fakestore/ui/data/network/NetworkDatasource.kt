package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.FakeStoreError

interface NetworkDatasource {
    suspend fun login(email: String, password: String): Either<FakeStoreError, AuthLogin>
}