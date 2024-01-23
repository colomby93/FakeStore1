package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.fakestore.ui.compose.components.Scaffold
import com.example.fakestore.ui.compose.components.TopBar

@Composable
fun MainScreen() {
    Column {
        Scaffold()
        TopBar()
    }

}