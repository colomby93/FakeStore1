package com.example.fakestore.ui.data

import com.example.fakestore.ui.data.network.NetworkDatasource
import com.example.fakestore.ui.data.preference.Preference
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.ProductForId
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

    override suspend fun getCategory(): Either<FakeStoreError, List<Category>> {
        return when (val categoryResponse = networkDatasource.getCategories()) {
            is Either.Left -> Either.Left(FakeStoreError.Network)
            is Either.Right -> categoryResponse
        }
    }

    override suspend fun getProductForCategory(categoryId: String): Either<FakeStoreError, List<ProductForCategory>> {
        return when (val productResponse = networkDatasource.getProductsForCategory(categoryId)) {
            is Either.Left -> Either.Left(FakeStoreError.Network)
            is Either.Right -> productResponse
        }
    }

    override suspend fun getProductForId(productForId: String): Either<FakeStoreError, ProductForId> {
        return when (val productResponse =
            networkDatasource.getProductForId(productForId = productForId)) {
            is Either.Left -> Either.Left(FakeStoreError.Network)
            is Either.Right -> productResponse
        }
    }

}