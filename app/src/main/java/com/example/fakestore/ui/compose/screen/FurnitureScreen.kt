package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.ItemProduct
import com.example.fakestore.ui.domain.model.Product

@Composable
fun FurnitureScreen(productListFurniture: List<Product>) {
    ItemProduct(productList = productListFurniture)
}