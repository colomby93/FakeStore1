package com.example.fakestore.ui.compose.screen

import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.mainScreen.ItemProductForCategory
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.viewmodel.MainScreenEvent
import com.example.fakestore.ui.viewmodel.MainScreenViewModel

@Composable
fun MiscellaneousScreen(
    productForCategoryListviewModelMiscellaneous: List<ProductForCategory>,
    state: MainScreenViewModel.UIState,
    onEvent: (MainScreenEvent) -> Unit
) {
    ItemProductForCategory(
        productForCategoryList = productForCategoryListviewModelMiscellaneous,
        state = state,
        onEvent = onEvent
    )
}