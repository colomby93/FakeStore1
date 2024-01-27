package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Product

interface NetworkDatasource {
    suspend fun login(email: String, password: String): Either<FakeStoreError, AuthLogin>
    suspend fun getProductsForCategory(categoryId: String): Either<FakeStoreError, List<Product> >
}