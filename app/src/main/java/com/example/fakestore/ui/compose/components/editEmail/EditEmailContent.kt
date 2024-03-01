package com.example.fakestore.ui.compose.components.editEmail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fakestore.ui.domain.model.UserProfile

@Composable
fun EditEmailContent(userProfile: UserProfile) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Email change", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Current email", color = Color.LightGray)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = userProfile.email)
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldEditEmail(title = "New email address")
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldEditEmail(title = "confirm your new email address")
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPassword(title = "Insert your password")
        Spacer(modifier = Modifier.height(70.dp))
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Save", color = Color.White)
        }

    }
}

@Preview
@Composable
fun EditEmailContentPreview() {
    EditEmailContent(UserProfile("", "Jhon@email.com", 1, "Jhon", "changeme", ""))
}