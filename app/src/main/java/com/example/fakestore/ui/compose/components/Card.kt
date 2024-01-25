package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fakestore.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem() {
    Row(horizontalArrangement = Arrangement.Center) {
        Card(
            onClick = { TODO() },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .weight(1f)
                .height(325.dp)
                .padding(end = 10.dp, start = 10.dp),
            elevation = CardDefaults.elevatedCardElevation()

        ) {
            Image(
                painter = painterResource(id = R.drawable.clothes),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Row(
                modifier = Modifier.align(Alignment.End)
            ) {
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "Price", modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = "Description product")


        }
        Card(
            onClick = { TODO() },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .weight(1f)
                .height(325.dp),
            elevation = CardDefaults.elevatedCardElevation()

        ) {
            Image(painter = painterResource(id = R.drawable._56322), contentDescription = null)
            Row {
                Text(text = "Price")
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null)
            }
            Text(text = "Description product")


        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CardItem()
}