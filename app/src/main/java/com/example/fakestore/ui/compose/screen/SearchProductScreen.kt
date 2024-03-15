package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.searchBar.SearchProduct
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.viewmodel.SearchProductEvent

@Composable
fun SearchProductScreen(
    product: List<Products>,
    onEvent: (SearchProductEvent) -> Unit
) {
    SearchProduct(product = product, onEvent = onEvent)
}
