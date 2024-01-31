package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fakestore.ui.compose.screen.MainScreen
import com.example.fakestore.ui.viewmodel.ElectronicViewModel
import com.example.fakestore.ui.viewmodel.FurnitureViewModel
import com.example.fakestore.ui.viewmodel.MainScreenViewModel


@Composable
fun MainScreenRoute(
    viewModel: MainScreenViewModel = hiltViewModel(),
    viewModelFurniture: FurnitureViewModel = hiltViewModel(),
    viewModelElectronic: ElectronicViewModel = hiltViewModel()
) {
    val productListClothes by viewModel.state.collectAsState()
    val productListFurniture by viewModelFurniture.state.collectAsState()
    val productListElectronic by viewModelElectronic.state.collectAsState()
    MainScreen(
        productListClothes = productListClothes.productList,
        productListFurniture = productListFurniture.productListFurniture,
        productListElectronic = productListElectronic.productListElectronic
    )
}