package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.ItemProduct
import com.example.fakestore.ui.domain.model.Product

@Composable
fun ElectronicScreen(productListElectronic: List<Product>) {
    ItemProduct(productList = productListElectronic)
}