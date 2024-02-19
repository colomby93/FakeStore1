package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.SearchProductScreen
import com.example.fakestore.ui.viewmodel.SearchProductViewModel

@Composable
fun SearchProductRoute(
    viewModel: SearchProductViewModel = hiltViewModel(),
    navController: NavController
) {
    val product by viewModel.state.collectAsState()
    SearchProductScreen(product = product.productsList) { viewModel.onEvent(it) }
}

