package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.screen.MainScreen
import com.example.fakestore.ui.viewmodel.MainScreenViewModel


@Composable
fun MainScreenRoute(
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    viewModel.getProductForCategory("1")
    val productList by viewModel.state.collectAsState()
    MainScreen(productList = productList.productList)
}