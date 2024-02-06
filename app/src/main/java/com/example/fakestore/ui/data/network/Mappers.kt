package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.data.network.model.CategoryDtoItem
import com.example.fakestore.ui.data.network.model.ProductForCategoryDtoItem
import com.example.fakestore.ui.data.network.model.ProductForIdDto
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.ProductForId

fun AuthLoginDto.toModel(): AuthLogin = AuthLogin(
    accessToken = accessToken,
    refreshToken = refreshToken
)

fun CategoryDtoItem.toModelCategories(): Category = Category(
    creationAt = creationAt,
    id = id,
    image = image,
    name = name,
    updatedAt = updatedAt
)


fun ProductForCategoryDtoItem.toModelCategory(): ProductForCategory = ProductForCategory(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt

)

fun ProductForIdDto.toModelProductId(): ProductForId = ProductForId(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt
)