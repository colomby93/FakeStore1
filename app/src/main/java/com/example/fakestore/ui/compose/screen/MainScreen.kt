package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.MainScreenHeader
import com.example.fakestore.ui.domain.model.Product

@Composable
fun MainScreen(productList: List<Product>) {
    MainScreenHeader(productList = productList)
}