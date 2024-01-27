package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.data.network.model.ProductForCategoryDtoItem
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.Product

fun AuthLoginDto.toModel(): AuthLogin = AuthLogin(
    accessToken = accessToken,
    refreshToken = refreshToken
)


fun ProductForCategoryDtoItem.toModelCategory(): Product = Product(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt

)