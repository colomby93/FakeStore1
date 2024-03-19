package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestore.R
import com.example.fakestore.ui.viewmodel.FailConnectionEvent

@Composable
fun FailConnectionScreen(onEvent: (FailConnectionEvent) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.internet_connection_lost_5379695_4503307),
            contentDescription = "Image lost internet"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Internet connection has failed", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { onEvent(FailConnectionEvent.OnClickButtonTryAgain) }, modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Try again")
        }
    }

}

@Preview
@Composable
fun FailConnectionScreenPreview() {
    FailConnectionScreen({})
}