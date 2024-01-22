package com.example.fakestore.ui.compose.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun FirstRoute(){
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.Yellow))
}