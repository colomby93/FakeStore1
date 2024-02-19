package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.ProductForCategory
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
class MainScreenViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    data class UIState(
        val loading: Boolean = false,
        val productForCategoryList: List<ProductForCategory> = emptyList(),
        val categoryList: List<Category> = emptyList(),
    )

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> = _state

    fun onEvent(mainScreenEvent: MainScreenEvent, navController: NavController) {
        when (mainScreenEvent) {
            is MainScreenEvent.OnProductClicked -> navigateToDetailProduct(
                productId = mainScreenEvent.productId,
                navController = navController
            )

            MainScreenEvent.OnClickIconSearch -> navigateToSearchProduct(navController = navController)
        }
    }

    init {
        getProductForCategory()
    }


    private fun getProductForCategory() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.update { it.copy(loading = true) }
                repository.getProductForCategory(Companion.CLOTHES_ID).fold(
                    error = {
                        Log.e(
                            "product request by category failed",
                            "product request by category failed"
                        )
                    },
                    success = { productList ->
                        _state.update {
                            it.copy(
                                productForCategoryList = productList,
                                loading = false
                            )
                        }
                    }
                )
            }
        }
    }

    private fun navigateToDetailProduct(productId: String, navController: NavController) {
        navController.navigate(screen = Screen.DetailProduct, args = PRODUCT_ID to productId)
    }

    private fun navigateToSearchProduct(navController: NavController) {
        navController.navigate(screen = Screen.SearchProduct)
    }


    companion object {
        private const val CLOTHES_ID = "1"
    }

}

sealed class MainScreenEvent {
    data class OnProductClicked(val productId: String) : MainScreenEvent()
    data object OnClickIconSearch : MainScreenEvent()


}










