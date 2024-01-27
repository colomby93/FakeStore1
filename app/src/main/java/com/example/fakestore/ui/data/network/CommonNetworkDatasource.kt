package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.LoginDto
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Product
import javax.inject.Inject

class CommonNetworkDatasource @Inject constructor(
    private val fakeStoreAPIService: FakeStoreAPIService,
) : NetworkDatasource {

    override suspend fun login(
        email: String, password: String
    ): Either<FakeStoreError, AuthLogin> {
        return try {
            val loginDto = LoginDto(email, password)
            Either.Right(fakeStoreAPIService.login(loginDto).body()!!.toModel())
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

    override suspend fun getProductsForCategory(categoryId: String): Either<FakeStoreError, List<Product>> {
        return try {
            Either.Right(fakeStoreAPIService.getProductsForCategory(categoryId).body()!!
                .map { it.toModelCategory() })
        } catch (e: Exception) {
            println(message = "error")
            Either.Left(FakeStoreError.Network)
        }
    }

}