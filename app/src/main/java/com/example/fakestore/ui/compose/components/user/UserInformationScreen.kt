package com.example.fakestore.ui.compose.components.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.fakestore.ui.domain.model.UserProfile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInformationScreen(userProfile: UserProfile) {
    Scaffold(topBar = {
        TopAppBar(navigationIcon = {
            IconButton(onClick = { TODO() }, content = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow back icon"
                )
            })
        }, title = { Text(text = "personal information") })
    }, content = {
        UserInformationContent(it, userProfile)
    })
}

@Composable
private fun UserInformationContent(paddingValues: PaddingValues, userProfile: UserProfile) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        AvatarUser(userProfile = userProfile)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = userProfile.name,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        )
        UserInformationField(
            icon = Icons.Filled.Email,
            title = "Email address",
            description = userProfile.email
        )
        Spacer(modifier = Modifier.height(8.dp))
        UserInformationField(
            icon = Icons.Filled.Password,
            title = "Password",
            description = userProfile.password.map { '*' }.joinToString(separator = " ")
        )
    }
}

@Composable
fun AvatarUser(userProfile: UserProfile) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(userProfile.avatar)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(50.dp))
    )
}

@Preview
@Composable
private fun AvatarUserPreview() {
    UserInformationScreen(
        UserProfile(
            "https://i.imgur.com/LDOO4Qs.jpg", "jhonatan@sss.com", 1, "Jose", "Password", "user"
        )
    )
}