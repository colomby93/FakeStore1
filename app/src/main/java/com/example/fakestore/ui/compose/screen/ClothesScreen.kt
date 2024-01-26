package com.example.fakestore.ui.compose.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.CardProduct
import com.example.fakestore.ui.compose.components.ItemProduct
import com.example.fakestore.ui.domain.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClothesScreen(productList: List<Product>){
    ItemProduct(productList = productList)
}