package com.example.fakestore.ui.compose.route

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.fakestore.ui.domain.model.Product

@Composable
fun FurnitureRoute() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ){
        Text(text = "Hola")
    }
}