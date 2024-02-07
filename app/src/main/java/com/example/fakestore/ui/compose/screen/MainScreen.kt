package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.MainScreenHeader
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.viewmodel.MainScreenEvent
import com.example.fakestore.ui.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    productForCategoryListClothes: List<ProductForCategory>,
    productForCategoryListFurniture: List<ProductForCategory>,
    productForCategoryListElectronic: List<ProductForCategory>,
    productForCategoryListShoes: List<ProductForCategory>,
    productForCategoryListviewModelMiscellaneous: List<ProductForCategory>,
    state: MainScreenViewModel.UIState,
    onEvent: (MainScreenEvent) -> Unit

) {
    MainScreenHeader(
        productForCategoryListClothes = productForCategoryListClothes,
        productForCategoryListFurniture = productForCategoryListFurniture,
        productForCategoryListElectronic = productForCategoryListElectronic,
        productForCategoryListShoes = productForCategoryListShoes,
        productForCategoryListviewModelMiscellaneous = productForCategoryListviewModelMiscellaneous,
        state= state,
        onEvent = onEvent
    )
}