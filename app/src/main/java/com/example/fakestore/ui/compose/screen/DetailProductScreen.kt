package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.detailProduc.BuyProduct
import com.example.fakestore.ui.compose.components.detailProduc.ToolbarDetailProduct
import com.example.fakestore.ui.domain.model.Product

@Composable
fun DetailProductScreen(imageProduct: List<Product>) {
    Column {
        ToolbarDetailProduct(product = imageProduct)
    }
}