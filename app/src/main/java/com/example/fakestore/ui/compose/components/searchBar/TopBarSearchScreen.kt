package com.example.fakestore.ui.compose.components.searchBar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun topBar() {
    var text by remember {
        mutableStateOf("")
    }
    TopAppBar {
        IconButton(onClick = { }, content = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Open dropdown menu"
            )
        })
        TextField(value = text, onValueChange = {text = it})
    }
}


@Preview
@Composable
fun pre() {
    topBar()
}