package com.example.fakestore.ui.compose.route

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.compose.screen.MainScreen
import com.example.fakestore.ui.viewmodel.ElectronicViewModel
import com.example.fakestore.ui.viewmodel.FurnitureViewModel
import com.example.fakestore.ui.viewmodel.MainScreenViewModel
import com.example.fakestore.ui.viewmodel.MiscellaneousViewModel
import com.example.fakestore.ui.viewmodel.ShoesViewModel


@Composable
fun MainScreenRoute(
    viewModel: MainScreenViewModel = hiltViewModel(),
    viewModelFurniture: FurnitureViewModel = hiltViewModel(),
    viewModelElectronic: ElectronicViewModel = hiltViewModel(),
    viewModelShoes: ShoesViewModel = hiltViewModel(),
    viewModelMiscellaneous: MiscellaneousViewModel = hiltViewModel(),
    navController: NavController

) {
    val productListClothes by viewModel.state.collectAsState()
    val productListFurniture by viewModelFurniture.state.collectAsState()
    val productListElectronic by viewModelElectronic.state.collectAsState()
    val productListShoes by viewModelShoes.state.collectAsState()
    val productListviewModelMiscellaneous by viewModelMiscellaneous.state.collectAsState()
    MainScreen(
        productForCategoryListClothes = productListClothes.productForCategoryList,
        productForCategoryListFurniture = productListFurniture.productForCategoryListFurniture,
        productForCategoryListElectronic = productListElectronic.productForCategoryListElectronic,
        productForCategoryListShoes = productListShoes.productForCategoryListShoes,
        productForCategoryListviewModelMiscellaneous = productListviewModelMiscellaneous.productForCategoryListMiscellaneous,
        state = viewModel.state.collectAsState().value
    )
    { viewModel.onEvent(it, navController) }
}