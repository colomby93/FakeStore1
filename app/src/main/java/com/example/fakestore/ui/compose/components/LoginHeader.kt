package com.example.fakestore.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fakestore.R

@Composable
fun LoginHeader(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = modifier.size(50.dp))
        Image(
            painter = painterResource(id = R.drawable.pngegg),
            contentDescription = "Logo E-Commerce"
        )
    }
}

