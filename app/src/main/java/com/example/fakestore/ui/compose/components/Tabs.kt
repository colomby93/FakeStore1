package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fakestore.ui.compose.route.CategoryRoute
import com.example.fakestore.ui.compose.route.HomeRoute
import com.example.fakestore.ui.compose.route.ProductsRoute
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(paddingValues: PaddingValues) {
    val tabs = listOf("Home", "Category", " Products")
    val pagerState = rememberPagerState(0)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            contentColor = Color.Black,
            backgroundColor = Color.White
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(index) } }
                )
            }
        }

        HorizontalPager(count = tabs.size, state = pagerState) { index ->
            when (index) {
                0 -> HomeRoute()
                1 -> CategoryRoute()
                2 -> ProductsRoute()
            }

        }


    }

}
