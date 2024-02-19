package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.Products
import com.example.fakestore.ui.navigation.PRODUCT_ID
import com.example.fakestore.ui.navigation.Screen
import com.example.fakestore.ui.navigation.navigate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchProductViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    data class UIState(
        val loading: Boolean = false,
        var productsList: List<Products> = emptyList(),
    )

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> = _state

    private var productList = emptyList<Products>()

    init {
        getProduct()
    }

    fun onEvent(searchProductEvent: SearchProductEvent, navController: NavController) {
        when (searchProductEvent) {
            is SearchProductEvent.OnTextChange -> filterProduct(searchProductEvent.onTextChange)
            is SearchProductEvent.OnTextSubmit -> filterProduct(searchProductEvent.onTextSubmit)
            is SearchProductEvent.OnProductClicked -> navigateToDetailProduct(
                searchProductEvent.productId,
                navController = navController
            )

            is SearchProductEvent.OnArrowBackClicked -> onArrowBack(navController = navController)
        }
    }

    private fun getProduct() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getProduct().fold(
                    error = { Log.e("Error in request ", "Fail request product") },
                    success = { product ->
                        productList = product
                        _state.update { it.copy(productsList = product, loading = false) }
                    }
                )
            }
        }
    }

    private fun filterProduct(product: String) {
        Log.e("text change", "$product")
        val searchProduct = productList.filter { it.title.contains(product.capitalize()) }
        _state.update { it.copy(productsList = searchProduct) }
    }

    private fun navigateToDetailProduct(productId: String, navController: NavController) {
        navController.navigate(screen = Screen.DetailProduct, args = PRODUCT_ID to productId)
    }

    private fun onArrowBack(navController: NavController) {
        if (navController.previousBackStackEntry != null) {
            navController.navigateUp()
        }
    }

}

sealed class SearchProductEvent {
    data class OnTextChange(val onTextChange: String) : SearchProductEvent()
    data class OnTextSubmit(val onTextSubmit: String) : SearchProductEvent()
    data class OnProductClicked(val productId: String) : SearchProductEvent()
    data object OnArrowBackClicked : SearchProductEvent()
}

