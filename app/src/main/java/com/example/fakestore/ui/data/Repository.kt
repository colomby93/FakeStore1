package com.example.fakestore.ui.data

import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Product
import com.example.fakestore.ui.domain.model.Success

interface Repository {
    suspend fun login(email: String, password: String): Either<FakeStoreError, Success>

    suspend fun getProductForCategory(categoryId: String): Either<FakeStoreError,List<Product>>
}