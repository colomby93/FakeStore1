package com.example.fakestore.ui.data

import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.ProductForId
import com.example.fakestore.ui.domain.model.Success

interface Repository {
    suspend fun login(email: String, password: String): Either<FakeStoreError, Success>

    suspend fun getCategory(): Either<FakeStoreError, List<Category>>

    suspend fun getProductForCategory(categoryId: String): Either<FakeStoreError, List<ProductForCategory>>
    suspend fun getProductForId(productForId: String): Either<FakeStoreError, ProductForId>

}