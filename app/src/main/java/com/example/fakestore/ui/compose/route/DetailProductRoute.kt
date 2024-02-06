package com.example.fakestore.ui.compose.route

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.screen.DetailProductScreen
import com.example.fakestore.ui.viewmodel.ProductDetailViewModel

@Composable
fun DetailProductRoute(viewModel: ProductDetailViewModel = hiltViewModel()) {
    val product by viewModel.state.collectAsState()
    Box(modifier = Modifier.verticalScroll(rememberScrollState())){
        product.product?.let { DetailProductScreen(product = it) }
    }


}
