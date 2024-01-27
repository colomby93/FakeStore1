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
class MainScreenViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    data class UIState(
        val loading: Boolean = false,
        val productList: List<Product> = emptyList()
    )

    private val _state = MutableStateFlow(UIState())
    var state: StateFlow<UIState> = _state

    private var listProduct = emptyList<Product>()

    fun getProductForCategory(categoryId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getProductForCategory(categoryId).fold(
                    error = { Log.e("Fallo peticion de red", "Fallo de red") },
                    success = { productList ->
                        listProduct = productList
                        _state.update {
                            it.copy(
                                productList = productList,
                                loading = false
                            )
                        }
                    }
                )
            }
        }
    }


}

