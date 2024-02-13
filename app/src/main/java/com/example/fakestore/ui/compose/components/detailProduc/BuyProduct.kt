package com.example.fakestore.ui.compose.components.detailProduc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.domain.model.Products

@Composable
fun BuyProduct(product: Products) {
    var expanded by remember { mutableStateOf(false) }
    var sizeSelected by remember { mutableStateOf("S") }
    val itemsSize = listOf("S", "M", "L", "XL", "XXL")
    Card(
        modifier = Modifier
            .padding(bottom = 0.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
            Color.White
        )
    ) {
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = product.price.toString() + " €")

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = product.title)

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = product.description)

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            ) {
                Text(text = "Add to Favorite", color = Color.Black)
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Icon favorite",
                    tint = Color.Black
                )
            }
            Divider(
                modifier = Modifier
                    .width(2.dp)
                    .height(20.dp)
            )
            Button(onClick = { expanded = true }, content = {
                Text(text = "Size", color = Color.Black)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = sizeSelected, color = Color.Black)
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Arrow drop menu",
                    tint = Color.Black
                )
                DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    itemsSize.forEachIndexed { index, size ->
                        DropdownMenuItem(text = {
                            Text(text = size, color = Color.Black)
                        }, onClick = { sizeSelected = size; expanded = false })
                    }
                }
            }, modifier = Modifier.weight(1f), shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            )


        }
        Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxHeight()) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                border = BorderStroke(1.dp, color = Color.Black)
            ) {
                Text(text = "Add to Card", fontWeight = FontWeight.ExtraBold, color = Color.Black)
            }
        }
    }
}
