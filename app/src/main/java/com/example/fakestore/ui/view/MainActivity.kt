package com.example.fakestore.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.fakestore.ui.compose.theme.FakeStoreTheme
import com.example.fakestore.ui.navigation.NavigationGraph
import com.example.fakestore.ui.viewmodel.ViewModelLogin
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModelLogin by viewModels<ViewModelLogin>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModelLogin.state.collect { state ->
                    if (state.loading) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
                }
            }
        }

        setContent {
            FakeStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(viewModelLogin)
                }
            }
        }
    }
}
