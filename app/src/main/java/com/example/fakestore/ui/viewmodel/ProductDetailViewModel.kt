package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.Products
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

    data class UIState(
        val loading: Boolean = false,
        val product: Products? = null,
        val buttonSizeVisibility: Boolean = true
    )

    private val _state = MutableStateFlow(UIState())
    var state: StateFlow<UIState> = _state

    var categoryId: Int = 0

    fun onEvent(detailProduct: DetailProduct, navController: NavController) {
        when (detailProduct) {
            is DetailProduct.OnArrowBackClicked -> onArrowBack(navController = navController)
        }
    }

    fun getProduct(productId: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getProductForId(productId).fold(
                    error = { Log.e("Error network", "Error network product for id") },
                    success = { product ->
                        categoryId = product.category.id
                        Log.e("categoryId", "$categoryId")
                        if (categoryId == 1) {
                            _state.update { it.copy(buttonSizeVisibility = true) }
                        } else {
                            _state.update { it.copy(buttonSizeVisibility = false) }
                        }
                        _state.update { it.copy(product = product, loading = false) }
                    }
                )
            }
        }
    }

    private fun onArrowBack(navController: NavController) {
        if (navController.previousBackStackEntry != null) {
            navController.navigateUp()
        }
    }

}

sealed class DetailProduct {
    data object OnArrowBackClicked : DetailProduct()
}