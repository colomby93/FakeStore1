package com.example.fakestore.ui.compose.components.userProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.fakestore.ui.viewmodel.UserProfileEvent

@Composable
fun UserInformationFieldEmail(
    icon: ImageVector,
    title: String,
    description: String,
    onEvent: (UserProfileEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = icon, contentDescription = ""
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, color = Color.LightGray)
            Spacer(modifier = Modifier.weight(1F))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Icon edit")
            }
        }
        Text(text = description)
    }
}

@Composable
fun UserInformationFieldPassword(
    icon: ImageVector,
    title: String,
    description: String,
    onEvent: (UserProfileEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector = icon, contentDescription = ""
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = title, color = Color.LightGray)
            Spacer(modifier = Modifier.weight(1F))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Icon edit")
            }
        }
        Text(text = description)
    }
}

@Composable
@Preview
fun InformationUserPreview() {
    UserInformationFieldEmail(Icons.Filled.Email, "Email address", "jhonatan@worldline.com", {})
}

