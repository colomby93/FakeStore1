@file:Suppress("UNUSED_EXPRESSION")

package com.example.fakestore.ui.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.compose.components.editEmail.EditEmailContent
import com.example.fakestore.ui.domain.model.UserProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEmailScreen(userProfile: UserProfile) {
    Scaffold(
        topBar = {
            TopAppBar(navigationIcon = {
                IconButton(onClick = { TODO() }, content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back icon"
                    )
                })
            }, title = { Text(text = "Email address", fontWeight = FontWeight.Bold) })
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .padding(horizontal = 16.dp)
            ) {
                HorizontalDivider(color = Color.LightGray)
                Spacer(modifier = Modifier.height(40.dp))
                EditEmailContent(userProfile = userProfile)
            }
        }
    )
}


@Preview
@Composable
fun EditEmailScreenPreview() {
    EditEmailScreen(UserProfile("", "Jhon@email.com", 1, "Jhon", "changeme", ""))
}