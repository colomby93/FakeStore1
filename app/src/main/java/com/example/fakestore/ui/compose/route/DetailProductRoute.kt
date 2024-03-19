package com.example.fakestore.ui.compose.route

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.DetailProductScreen
import com.example.fakestore.ui.viewmodel.ProductDetailViewModel

@Composable
fun DetailProductRoute(
    productId: String,
    viewModel: ProductDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    viewModel.getProduct(productId)
    val product by viewModel.state.collectAsState()

    Box {
        product.product?.let { product ->
            DetailProductScreen(product = product, state = viewModel.state.collectAsState().value) {
                viewModel.onEvent(
                    it,
                    navController
                )
            }
        }
    }
}
