package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fakestore.ui.compose.route.CategoryRoute
import com.example.fakestore.ui.compose.route.HomeRoute
import com.example.fakestore.ui.compose.route.ProductsRoute
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(paddingValues: PaddingValues) {
    val tabs = listOf("Home", "Category", " Products")

    val tabIndex = remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxWidth()
    ) {
        TabRow(selectedTabIndex = tabIndex.intValue, contentColor = Color.Black, backgroundColor = Color.White) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex.intValue == index,
                    onClick = { tabIndex.intValue = index }
                )
            }
        }
        when (tabIndex.intValue){
            0 -> HomeRoute()
            1-> CategoryRoute()
            2-> ProductsRoute()
        }
    }

}


/*
@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsItem(tabs: List<TabsItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}*/