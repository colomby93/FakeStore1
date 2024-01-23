package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fakestore.ui.core.TabsItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopBar() {
    val tabs = listOf(
        TabsItem.ItemHome,
        TabsItem.ItemCategory,
        TabsItem.ItemCategory
    )
    val pageState = rememberPagerState()
    Column {
        Tabs(tabs, pageState)
        TabsItem(tabs, pageState)
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    tabs: List<TabsItem>,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()
    TabRow(selectedTabIndex = pagerState.currentPage, contentColor = Color.Black) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title.title, color = Color.Black) },
                selected = pagerState.currentPage == index,
                onClick = {},
                modifier = Modifier.background(Color.White)
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsItem(tabs: List<TabsItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}
