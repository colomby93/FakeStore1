package com.example.fakestore.ui.compose.components.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.example.fakestore.ui.compose.route.ClothesRoute
import com.example.fakestore.ui.compose.screen.ElectronicScreen
import com.example.fakestore.ui.compose.screen.FurnitureScreen
import com.example.fakestore.ui.compose.screen.MiscellaneousScreen
import com.example.fakestore.ui.compose.screen.ShoesScreen
import com.example.fakestore.ui.compose.theme.light_grey_2
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.viewmodel.MainScreenEvent
import com.example.fakestore.ui.viewmodel.MainScreenViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    paddingValues: PaddingValues,
    productForCategoryList: List<ProductForCategory>,
    productForCategoryListFurniture: List<ProductForCategory>,
    productForCategoryListElectronic: List<ProductForCategory>,
    productForCategoryListShoes: List<ProductForCategory>,
    productForCategoryListviewModelMiscellaneous: List<ProductForCategory>,
    state: MainScreenViewModel.UIState,
    onEvent: (MainScreenEvent) -> Unit
) {
    val tabs = listOf("Clothes", "Furniture", " Electronics", "Shoes", " Miscellaneous")
    val pagerState = rememberPagerState(0)
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
            .background(light_grey_2)
    ) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            contentColor = Color.Black,
            containerColor = Color.White
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title, overflow = TextOverflow.Ellipsis) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch { pagerState.animateScrollToPage(index) }
                    }
                )
            }
        }

        HorizontalPager(count = tabs.size, state = pagerState) { index ->
            when (index) {
                0 -> ClothesRoute(productForCategoryList, state, onEvent)
                1 -> FurnitureScreen(productForCategoryListFurniture, state, onEvent)
                2 -> ElectronicScreen(productForCategoryListElectronic, state, onEvent)
                3 -> ShoesScreen(productForCategoryListShoes, state, onEvent)
                4 -> MiscellaneousScreen(
                    productForCategoryListviewModelMiscellaneous,
                    state,
                    onEvent
                )
            }
        }
    }

}
