package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.ItemProduct
import com.example.fakestore.ui.domain.model.ProductForCategory

@Composable
fun ClothesRoute(productForCategoryList: List<ProductForCategory>) {
    ItemProduct(productForCategoryList = productForCategoryList)
}