package com.example.fakestore.ui.domain.model

import com.example.fakestore.ui.data.network.model.CategoryX

data class Products(
    val category: CategoryX,
    val creationAt: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String,
    val updatedAt: String
)
