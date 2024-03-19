package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.detailProduc.ToolbarDetailProduct
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.viewmodel.DetailProduct
import com.example.fakestore.ui.viewmodel.MainScreenViewModel
import com.example.fakestore.ui.viewmodel.ProductDetailViewModel

@Composable
fun DetailProductScreen(
    product: Products,
    state: ProductDetailViewModel.UIState,
    onEvent: (DetailProduct) -> Unit
) {
    ToolbarDetailProduct(
        product = product,
        state = state,
        onEvent = onEvent
    )
}