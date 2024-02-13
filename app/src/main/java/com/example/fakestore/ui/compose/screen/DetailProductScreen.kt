package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.detailProduc.ToolbarDetailProduct
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.viewmodel.DetailProduct

@Composable
fun DetailProductScreen(product: Products, onEvent: (DetailProduct) -> Unit) {
    ToolbarDetailProduct(product = product, onEvent = onEvent)
}