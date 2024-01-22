@file:Suppress("UNUSED_EXPRESSION")

package com.example.fakestore.ui.compose.components

import android.widget.Toast
import android.widget.Toast.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestore.R
import com.example.fakestore.ui.compose.theme.light_grey
import com.example.fakestore.ui.compose.theme.tertiary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    isErrorLogin: Boolean
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.login),
            fontSize = 35.sp,
            color = light_grey,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                onEmailChanged(it)
            },
            label = { Text(text = "Address email", color = Color.White) },

            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            isError = isErrorLogin,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, top = 0.dp, end = 20.dp)
        )
        val icon = if (passwordVisibility) painterResource(id = R.drawable.design_ic_visibility)
        else painterResource(id = R.drawable.design_ic_visibility_off)

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                onPasswordChanged(it)
            },
            label = { Text(text = "Password", color = Color.White) },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon, contentDescription = "Visibility Icon"
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            isError = isErrorLogin,
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, top = 0.dp, end = 20.dp)
        )
        Button(
            onClick = { onLoginClicked() },
            shape = RoundedCornerShape(2.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = tertiary)

        ) {
            Text(text = "Login in ", color = Color.White)
        }
    }
    if (isErrorLogin) {
        Toast.makeText(context, "Email o password incorrect", Toast.LENGTH_LONG).show()
    }

}

