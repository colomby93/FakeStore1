package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fakestore.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold() {
    var showMenu by remember {
        mutableStateOf(false)
    }
    Column {
        TopAppBar(navigationIcon = {
            IconButton(onClick = {
                showMenu = !showMenu
            }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Open dropdown menu")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { /*TODO*/ },
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pngegg),
                    contentDescription = "Logo",
                    alignment = Alignment.Center
                )
                DropdownMenuItem(leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = "Icon person"
                    )
                }, text = {
                    Text(text = "MY ACCOUNT")
                },

                    onClick = { /*TODO*/ })
                Divider(
                    Modifier
                        .background(Color.DarkGray)
                        .height(1.dp)
                        .fillMaxWidth()
                )
                DropdownMenuItem(leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Icon Saved articles"
                    )
                }, text = {
                    Text(text = "SAVED ARTICLES")
                }, onClick = { /*TODO*/ })
                Divider(
                    Modifier
                        .background(Color.DarkGray)
                        .height(1.dp)
                        .fillMaxWidth()
                )
                DropdownMenuItem(leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Icon shopping cart"
                    )
                }, text = {
                    Text(text = "SHOPPING CART")
                }, onClick = { /*TODO*/ })
                Divider(
                    Modifier
                        .background(Color.DarkGray)
                        .height(1.dp)
                        .fillMaxWidth()
                )
            }

        }, title = { Text(text = "Fake store") }, actions = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More")
            }
        })
        Divider(
            Modifier
                .background(Color.LightGray)
                .height(2.dp)
                .fillMaxWidth()
        )
    }

}
