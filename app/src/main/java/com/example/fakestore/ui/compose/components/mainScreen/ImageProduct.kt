package com.example.fakestore.ui.compose.components.mainScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.domain.model.Products

@Composable
fun ImageProductForCategory(productForCategory: ProductForCategory) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(productForCategory.images.first())
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
fun ImageProduct(product: Products) {
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
