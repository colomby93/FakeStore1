package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.LoginDto
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.domain.model.UserProfile
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

    override suspend fun getCategories(): Either<FakeStoreError, List<Category>> {
        return try {
            Either.Right(
                fakeStoreAPIService.getCategories().body()!!.map { it.toModelCategories() })
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

    override suspend fun getProductsForCategory(categoryId: String): Either<FakeStoreError, List<ProductForCategory>> {
        return try {
            Either.Right(fakeStoreAPIService.getProductsForCategory(categoryId).body()!!
                .map { it.toModelCategory() })
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

    override suspend fun getProductForId(productForId: String): Either<FakeStoreError, Products> {
        return try {
            Either.Right(
                fakeStoreAPIService.getProductForId(productForId).body()!!
                    .toModelProduct()
            )
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

    override suspend fun getProduct(): Either<FakeStoreError, List<Products>> {
        return try {
            Either.Right(
                fakeStoreAPIService.getAllProducts().body()!!.map { it.toModelProduct() }
            )
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

    override suspend fun getUserProfile(token: String): Either<FakeStoreError, UserProfile> {
        return try {
            Either.Right(
                fakeStoreAPIService.getUserDetail(token = token).body()!!.toModelUser()
            )
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

    override suspend fun putParameterUser(
        userId: String,
        parameter: UserProfile
    ): Either<FakeStoreError, UserProfile> {
        return try {
            Either.Right(
                fakeStoreAPIService.putParameterUser(userId = userId, parameterUser = parameter)
                    .body()!!
                    .toModelUser()
            )
        } catch (e: Exception) {
            Either.Left(FakeStoreError.Network)
        }
    }

}