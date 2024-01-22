package com.example.fakestore.ui.data

import com.example.fakestore.ui.data.network.NetworkDatasource
import com.example.fakestore.ui.data.preference.Preference
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Success
import javax.inject.Inject

class CommonRepository @Inject constructor(
    private val networkDatasource: NetworkDatasource,
    private val preference: Preference
) : Repository {
    override suspend fun login(email: String, password: String): Either<FakeStoreError, Success> {
        return networkDatasource.login(email, password).flatMap {
            print(it.success)
            preference.token(it.success.accessToken)
            Either.Right(Success)
        }
    }

}