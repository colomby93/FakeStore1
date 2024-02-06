package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.MainScreenHeader
import com.example.fakestore.ui.domain.model.ProductForCategory

@Composable
fun MainScreen(
    productForCategoryListClothes: List<ProductForCategory>,
    productForCategoryListFurniture: List<ProductForCategory>,
    productForCategoryListElectronic: List<ProductForCategory>,
    productForCategoryListShoes: List<ProductForCategory>,
    productForCategoryListviewModelMiscellaneous: List<ProductForCategory>
) {
    MainScreenHeader(
        productForCategoryListClothes = productForCategoryListClothes,
        productForCategoryListFurniture = productForCategoryListFurniture,
        productForCategoryListElectronic = productForCategoryListElectronic,
        productForCategoryListShoes = productForCategoryListShoes,
        productForCategoryListviewModelMiscellaneous = productForCategoryListviewModelMiscellaneous
    )
}