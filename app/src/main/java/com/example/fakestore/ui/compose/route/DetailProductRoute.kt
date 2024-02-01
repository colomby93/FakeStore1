package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.components.SliderImage
import com.example.fakestore.ui.viewmodel.MainScreenViewModel

@Composable
fun DetailProductRoute(viewModel: MainScreenViewModel = hiltViewModel()){
    val imageProduct by viewModel.state.collectAsState()
    SliderImage(product = imageProduct.productList)
}
