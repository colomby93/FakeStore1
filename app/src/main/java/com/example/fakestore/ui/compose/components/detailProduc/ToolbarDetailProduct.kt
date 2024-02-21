package com.example.fakestore.ui.compose.components.detailProduc

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.viewmodel.DetailProduct

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarDetailProduct(product: Products, onEvent: (DetailProduct) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = { onEvent(DetailProduct.OnArrowBackClicked) }, content = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Open dropdown menu"
                    )
                })


            }, title = {},
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ShoppingCart,
                            contentDescription = "Shopping cart"
                        )
                    }
                }
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                SliderImage(product = product, it)
                BuyProduct(product = product)
            }

        }

    )
}