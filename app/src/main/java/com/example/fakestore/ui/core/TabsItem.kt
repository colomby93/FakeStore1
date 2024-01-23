package com.example.fakestore.ui.core

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.route.CategoryRoute
import com.example.fakestore.ui.compose.route.MainScreenRoute
import com.example.fakestore.ui.compose.route.ProductsRoute


typealias MyFunction = @Composable () -> Unit

sealed class TabsItem(
    var title: String,
    var screen: MyFunction
) {
    data object ItemHome : TabsItem("Home", { MainScreenRoute() })
    data object ItemCategory : TabsItem("Category", { CategoryRoute() })
    data object ItemProducts : TabsItem("Products", { ProductsRoute() })
}
