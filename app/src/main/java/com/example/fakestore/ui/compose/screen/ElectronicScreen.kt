package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.ItemProductForCategory
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.viewmodel.MainScreenEvent
import com.example.fakestore.ui.viewmodel.MainScreenViewModel

@Composable
fun ElectronicScreen(
    productForCategoryListElectronic: List<ProductForCategory>,
    state: MainScreenViewModel.UIState,
    onEvent: (MainScreenEvent) -> Unit
) {
    ItemProductForCategory(
        productForCategoryList = productForCategoryListElectronic,
        state = state,
        onEvent = onEvent
    )
}