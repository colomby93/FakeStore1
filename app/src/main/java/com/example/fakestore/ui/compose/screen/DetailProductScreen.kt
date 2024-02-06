package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.detailProduc.ToolbarDetailProduct
import com.example.fakestore.ui.domain.model.ProductForId

@Composable
fun DetailProductScreen(product: ProductForId) {
    ToolbarDetailProduct(product = product)
}