package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.fakestore.ui.compose.screen.MainScreen
import com.example.fakestore.ui.viewmodel.MainScreenViewModel


@Composable
fun MainScreenRoute(viewModel: MainScreenViewModel) {
    viewModel.getProductForCategory("1")
    MainScreen(productList = viewModel.state.collectAsState().value.productList)
}