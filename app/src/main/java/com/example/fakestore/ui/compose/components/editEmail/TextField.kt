package com.example.fakestore.ui.compose.components.editEmail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fakestore.R

@Composable
fun TextFieldEditEmail(title: String) {
    var text by remember {
        mutableStateOf("")
    }
    Column {
        Text(text = title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = text,
            onValueChange = { text = it },
            shape = RoundedCornerShape(9.dp),
            modifier = Modifier
                .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
        )
    }
}

@Composable
fun TextFieldPassword(title: String) {
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) painterResource(id = R.drawable.design_ic_visibility)
    else painterResource(id = R.drawable.design_ic_visibility_off)
    Column {
        Text(text = title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(9.dp)
        )
    }

}


@Preview
@Composable
private fun AvatarUserPreview() {
    TextFieldEditEmail("New email address")
}