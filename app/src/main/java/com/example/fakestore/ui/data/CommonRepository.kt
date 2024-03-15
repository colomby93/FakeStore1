package com.example.fakestore.ui.data

import com.example.fakestore.ui.data.network.NetworkDatasource
import com.example.fakestore.ui.data.preference.Preferences
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.domain.model.Success
import com.example.fakestore.ui.domain.model.UserProfile
import javax.inject.Inject

class CommonRepository @Inject constructor(
    private val networkDatasource: NetworkDatasource,
    private val preferences: Preferences
) : Repository {

    override suspend fun login(email: String, password: String): Either<FakeStoreError, Success> {
        return networkDatasource.login(email, password).flatMap {
            preferences.setToken(it.success.accessToken)
            Either.Right(Success)
        }
    }

    override suspend fun getCategory(): Either<FakeStoreError, List<Category>> {
        return networkDatasource.getCategories()
    }

    override suspend fun getProductForCategory(categoryId: String): Either<FakeStoreError, List<ProductForCategory>> {
        return networkDatasource.getProductsForCategory(categoryId)
    }

    override suspend fun getProductForId(productForId: String): Either<FakeStoreError, Products> {
        return networkDatasource.getProductForId(productForId = productForId)
    }

    override suspend fun getProduct(): Either<FakeStoreError, List<Products>> {
        return networkDatasource.getProduct()
    }

    override suspend fun getUserProfile(): Either<FakeStoreError, UserProfile> {
        return networkDatasource.getUserProfile("Bearer ${preferences.getToken()}")
    }

    override suspend fun putParameterUSer(
        userId: String,
        parameter: UserProfile
    ): Either<FakeStoreError, UserProfile> {
        return networkDatasource.putParameterUser(userId = userId, parameter = parameter)
    }

}