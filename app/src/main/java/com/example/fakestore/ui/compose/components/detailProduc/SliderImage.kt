package com.example.fakestore.ui.compose.components.detailProduc

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestore.ui.domain.model.ProductForId
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SliderImage(product: ProductForId, paddingValues: PaddingValues) {
    val pagerState = rememberPagerState(pageCount = {
        product.images.size
    })

    HorizontalPager(state = pagerState) { page ->
        Card(
            Modifier
                .height(500.dp)
                .padding(paddingValues)
                .wrapContentWidth()
                .graphicsLayer {
                    val pageOffset = (
                            (pagerState.currentPage - page) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
            shape = RoundedCornerShape(30.dp)
        ) {
            Box {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.images[page % product.images.size])
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )


                Row(
                    Modifier
                        .height(400.dp)
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.Black else Color.White
                        val colorBorder =
                            if (pagerState.currentPage == iteration) Color.White else Color.LightGray
                        val border =
                            if (pagerState.currentPage == iteration) 3.dp else 1.dp
                        val size =
                            if (pagerState.currentPage == iteration) 20.dp else 10.dp
                        val padding =
                            if (pagerState.currentPage == iteration) 6.dp else 10.dp
                        Box(
                            modifier = Modifier
                                .padding(padding)
                                .clip(CircleShape)
                                .background(color)
                                .size(size)
                                .border(border, colorBorder, shape = CircleShape)
                        )
                    }
                }

            }

        }
    }
}