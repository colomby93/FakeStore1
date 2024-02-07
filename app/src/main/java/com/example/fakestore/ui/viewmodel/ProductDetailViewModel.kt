package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.ProductForId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _state = MutableStateFlow(UIState())
    var state: StateFlow<UIState> = _state

    fun getProduct(productId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getProductForId(productId).fold(
                    error = { Log.e("Error network", "Error network product for id") },
                    success = { product ->
                        _state.update { it.copy(product = product, loading = false) }
                    }
                )
            }
        }
    }
}

data class UIState(
    val loading: Boolean = false,
    val product: ProductForId? = null
)