package com.example.fakestore.ui.compose.components.mainScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.domain.model.Product

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardProduct(product: Product) {
    Column(modifier = Modifier.padding(10.dp)) {
        Card(
            onClick = { TODO() },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .width(400.dp)
                .wrapContentHeight(),
            elevation = CardDefaults.elevatedCardElevation(),
            border = BorderStroke(2.dp, Color.LightGray),
            colors = CardDefaults.cardColors(Color.LightGray)

        ) {
            ImageProduct(product = product)
            Spacer(modifier = Modifier.size(5.dp))
            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Price = " + product.price,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.Red
                )
            }
            Text(text = product.title, modifier = Modifier.padding(8.dp))


        }
    }

}

@Composable
fun ItemProduct(productList: List<Product>) {
    LazyColumn(content = {
        items(productList) { product ->
            CardProduct(product = product)
        }
    })
}

