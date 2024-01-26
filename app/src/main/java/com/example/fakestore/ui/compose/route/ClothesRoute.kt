package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.screen.ClothesScreen
import com.example.fakestore.ui.domain.model.Product

@Composable
fun ClothesRoute(productList: List<Product>) {
    ClothesScreen(productList = productList)
}