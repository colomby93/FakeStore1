package com.example.fakestore.ui.compose.components.reusable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun ImageItem(imageUrl: String) {
    // Efficient image loading with Coil
    Image(
        painter = rememberImagePainter(
            data = imageUrl
        ),
        contentDescription = null, // Provide content description as needed
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()
    )
}