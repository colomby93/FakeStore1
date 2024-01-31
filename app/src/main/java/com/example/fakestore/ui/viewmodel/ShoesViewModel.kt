package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShoesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    data class UIState(
        val loading: Boolean = false,
        val productListShoes: List<Product> = emptyList()
    )

    private val _state = MutableStateFlow(UIState())
    var state: StateFlow<UIState> = _state

    init {
        getProductForCategory()
    }


    private fun getProductForCategory() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getProductForCategory(SHOES_ID).fold(
                    error = {
                        Log.e(
                            "product request by category failed",
                            "product request by category failed"
                        )
                    },
                    success = { productList ->
                        _state.update {
                            it.copy(
                                productListShoes = productList,
                                loading = false
                            )
                        }
                    }
                )
            }
        }
    }

    companion object {
        private const val SHOES_ID = "4"
    }


}