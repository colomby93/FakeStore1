package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.ItemProduct
import com.example.fakestore.ui.domain.model.Product

@Composable
fun ClothesRoute(productList: List<Product>) {
    ItemProduct(productList = productList)
}