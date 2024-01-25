package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.fakestore.R
@ExperimentalMaterial3Api
@Composable
fun CardItem() {
    Card(onClick = { /*TODO*/ }) {

        Image(painter = painterResource(id = R.drawable._56322), contentDescription = "Product image ")
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    CardItem()
}