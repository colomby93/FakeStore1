package com.example.fakestore.ui.compose.components.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fakestore.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    modifier: Modifier = Modifier,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet(modifier = Modifier) {
        DrawerHeader(modifier)
        Spacer(modifier = Modifier.padding(5.dp))
        NavigationDrawerItem(
            label = {
                Text(
                    text = "MY ACCOUNT",
                    style = MaterialTheme.typography.labelSmall
                )
            },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Person, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        Divider(
            Modifier
                .background(Color.LightGray)
                .height(2.dp)
                .fillMaxWidth()
        )

        NavigationDrawerItem(
            label = { Text(text = "SAVED ARTICLES", style = MaterialTheme.typography.labelSmall) },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        Divider(
            Modifier
                .background(Color.LightGray)
                .height(2.dp)
                .fillMaxWidth()
        )

        NavigationDrawerItem(
            label = { Text(text = "SHOPPING CART", style = MaterialTheme.typography.labelSmall) },
            selected = false,
            onClick = {
                closeDrawer()
            },
            icon = { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null) },
            shape = MaterialTheme.shapes.small
        )

        Divider(
            Modifier
                .background(Color.LightGray)
                .height(2.dp)
                .fillMaxWidth()
        )
    }
}


@Composable
fun DrawerHeader(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
    ) {

        Image(
            painterResource(id = R.drawable.pngegg),
            contentDescription = "Logo Magneto",
            contentScale = ContentScale.Crop
        )

    }
}