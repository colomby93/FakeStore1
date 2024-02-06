package com.example.fakestore.ui.compose.route

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.screen.DetailProductScreen
import com.example.fakestore.ui.viewmodel.ProductDetailViewModel

@Composable
fun DetailProductRoute(viewModel: ProductDetailViewModel = hiltViewModel()) {
    val product by viewModel.state.collectAsState()
    Box {
        product.product?.let { DetailProductScreen(product = it) }
    }


}
