package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.MainScreenHeader
import com.example.fakestore.ui.domain.model.Product

@Composable
fun MainScreen(productListClothes: List<Product>, productListFurniture: List<Product>) {
    MainScreenHeader(productListClothes = productListClothes, productListFurniture = productListFurniture)
}