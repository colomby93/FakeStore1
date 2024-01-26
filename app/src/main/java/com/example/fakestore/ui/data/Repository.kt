package com.example.fakestore.ui.data

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fakestore.ui.data.network.model.ProductForCategoryDtoItem
import com.example.fakestore.ui.domain.Either
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.FakeStoreError
import com.example.fakestore.ui.domain.model.Product
import com.example.fakestore.ui.domain.model.Success

interface Repository {
    suspend fun login(email: String, password: String): Either<FakeStoreError, Success>

    suspend fun getProductForCategory(productId: String): Either<FakeStoreError,List<Product>>
}