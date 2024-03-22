package com.example.fakestore.ui.compose.components.reusable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail(title: String, onEvent: (String) -> Unit, state: Boolean) {
    var text by remember {
        mutableStateOf("")
    }
    Column {
        Text(text = title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = text,
            onValueChange = {
                text = it
                onEvent(it)
            },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            isError = state

        )
    }
}