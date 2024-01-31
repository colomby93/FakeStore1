package com.example.fakestore.ui.compose.components

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
import com.example.fakestore.ui.compose.route.MiscellaneousRoute
import com.example.fakestore.ui.compose.screen.ElectronicScreen
import com.example.fakestore.ui.compose.screen.FurnitureScreen
import com.example.fakestore.ui.compose.screen.ShoesScreen
import com.example.fakestore.ui.domain.model.Product
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    paddingValues: PaddingValues,
    productList: List<Product>,
    productListFurniture: List<Product>,
    productListElectronic: List<Product>,
    productListShoes: List<Product>
) {
    val tabs = listOf("Clothes", "Furniture", " Electronics", "Shoes", " Miscellaneous")
    val pagerState = rememberPagerState(0)
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
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
                0 -> ClothesRoute(productList)
                1 -> FurnitureScreen(productListFurniture)
                2 -> ElectronicScreen(productListElectronic)
                3 -> ShoesScreen(productListShoes)
                4 -> MiscellaneousRoute()
            }

        }


    }

}
