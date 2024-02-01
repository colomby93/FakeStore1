package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestore.ui.domain.model.Product

@Composable
fun ImageProduct(product: Product) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(product.images.first())
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()
    )
}


@Composable
fun AllImageProduct(product: List<Product>) {
    Box(modifier = Modifier.background(Color.Red)) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://i.imgur.com/KeqG6r4.jpeg")
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,

            )
    }
}