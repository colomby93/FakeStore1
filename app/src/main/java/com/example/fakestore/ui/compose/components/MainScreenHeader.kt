package com.example.fakestore.ui.compose.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun MainScreenHeader() {

    Scaffold(
        topBar = {
            TopBar()
        },
        content = {
            Tabs(it)
        }
    )

}

