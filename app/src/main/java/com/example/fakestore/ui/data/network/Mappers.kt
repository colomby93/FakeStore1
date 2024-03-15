package com.example.fakestore.ui.data.network

import com.example.fakestore.ui.data.network.model.AuthLoginDto
import com.example.fakestore.ui.data.network.model.CategoryDtoItem
import com.example.fakestore.ui.data.network.model.ProductDto
import com.example.fakestore.ui.data.network.model.ProductForCategoryDtoItem
import com.example.fakestore.ui.data.network.model.UserProfileDto
import com.example.fakestore.ui.domain.model.AuthLogin
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.domain.model.UserProfile

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

fun ProductDto.toModelProduct(): Products = Products(
    category = category,
    creationAt = creationAt,
    description = description,
    id = id,
    images = images,
    price = price,
    title = title,
    updatedAt = updatedAt
)

fun UserProfileDto.toModelUser(): UserProfile = UserProfile(
    avatar = avatar,
    email = email,
    id = id,
    name = name,
    password = password,
    role = role
)