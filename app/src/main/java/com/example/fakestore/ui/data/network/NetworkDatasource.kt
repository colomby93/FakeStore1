package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.domain.model.UserProfile

interface NetworkDatasource {
    suspend fun login(email: String, password: String): Either<FakeStoreError, AuthLogin>
    suspend fun getCategories(): Either<FakeStoreError, List<Category>>
    suspend fun getProductsForCategory(categoryId: String): Either<FakeStoreError, List<ProductForCategory>>
    suspend fun getProductForId(productForId: String): Either<FakeStoreError, Products>
    suspend fun getProduct(): Either<FakeStoreError, List<Products>>
    suspend fun getUserProfile(token: String): Either<FakeStoreError, UserProfile>
    suspend fun putParameterUser(
        userId: String,
        parameter: UserProfile
    ): Either<FakeStoreError, UserProfile>
}