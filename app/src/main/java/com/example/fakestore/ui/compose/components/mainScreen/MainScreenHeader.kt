package com.example.fakestore.ui.compose.components.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.domain.model.ProductForCategory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenHeader(
    productForCategoryListClothes: List<ProductForCategory>,
    productForCategoryListFurniture: List<ProductForCategory>,
    productForCategoryListElectronic: List<ProductForCategory>,
    productForCategoryListShoes: List<ProductForCategory>,
    productForCategoryListviewModelMiscellaneous: List<ProductForCategory>
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(modifier = Modifier, closeDrawer = { scope.launch { drawerState.close() } }

        )
    }, drawerState = drawerState) {
        Scaffold(topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = {
                    scope.launch { drawerState.open() }
                }, content = {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Open dropdown menu"
                    )
                })


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
        }, content = {
            Tabs(
                it,
                productForCategoryListClothes,
                productForCategoryListFurniture,
                productForCategoryListElectronic,
                productForCategoryListShoes,
                productForCategoryListviewModelMiscellaneous
            )
        }, modifier = Modifier.fillMaxWidth()
        )
    }

}

