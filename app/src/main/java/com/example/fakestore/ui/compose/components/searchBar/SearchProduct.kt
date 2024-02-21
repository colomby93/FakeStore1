package com.example.fakestore.ui.compose.components.searchBar

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.viewmodel.SearchProductEvent
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun SearchProduct(
    product: List<Products>,
    onEvent: (SearchProductEvent) -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(true)
    }

    val permissionState = rememberPermissionState(
        permission = Manifest.permission.RECORD_AUDIO
    )
    SideEffect {
        permissionState.launchPermissionRequest()
    }
    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = SpeechRecognizerContract(),
        onResult = {
            if (it != null) {
                text = it.joinToString()
                onEvent(SearchProductEvent.OnTextChange(it.joinToString()))
            }
        }
    )

    Row(modifier = Modifier.fillMaxWidth()) {
        SearchBar(
            query = text,
            onQueryChange = {
                text = it
                onEvent(SearchProductEvent.OnTextChange(it))
                onEvent(SearchProductEvent.OnTextSubmit(it))
            },
            onSearch = { active },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Search product") },
            leadingIcon = {
                IconButton(onClick = { onEvent(SearchProductEvent.OnArrowBackClicked) }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Icon arrowBack"
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (permissionState.status.isGranted) {
                        speechRecognizerLauncher.launch(Unit)
                    } else
                        permissionState.launchPermissionRequest()
                }) {
                    Icon(
                        imageVector = Icons.Default.SettingsVoice,
                        contentDescription = "Settings Voice"
                    )
                }
            },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp),
            colors = SearchBarDefaults.colors(Color.White)
        ) {
            ItemProduct(productList = product, onEvent = onEvent)
        }
    }
}



