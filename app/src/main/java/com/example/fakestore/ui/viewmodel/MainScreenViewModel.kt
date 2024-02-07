package com.example.fakestore.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.domain.model.Category
import com.example.fakestore.ui.domain.model.ProductForCategory
import com.example.fakestore.ui.navigation.PRODUCT_ID
import com.example.fakestore.ui.navigation.Screen
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

    private var productId: String = "1"

    data class UIState(
        val loading: Boolean = false,
        val productForCategoryList: List<ProductForCategory> = emptyList(),
        val categoryList: List<Category> = emptyList()
    )

    private val _state = MutableStateFlow(UIState())
    val state: StateFlow<UIState> = _state

    fun onEvent(mainScreenEvent: MainScreenEvent, navController: NavController) {
        when (mainScreenEvent) {
            is MainScreenEvent.ProductId -> onProductId(mainScreenEvent.productId)
            is MainScreenEvent.OnProductClicked -> navigateToDetailProduct(
                productId = productId,
                navController = navController
            )

        }
    }

    private fun onProductId(productId: String){
        this.productId = productId
        Log.e("product id","este es el id $productId")
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
        navController.navigate(route = Screen.DetailProduct.route) {
            navController.navigate(screen = Screen.DetailProduct, args = PRODUCT_ID to productId)
        }
    }

    companion object {
        private const val CLOTHES_ID = "1"
    }

}

sealed class MainScreenEvent {
    data object OnProductClicked : MainScreenEvent()
    data class ProductId(val productId: String) : MainScreenEvent()

}

fun NavController.navigate(
    screen: Screen, args: Pair<String, String>? = null, builder: NavOptionsBuilder.() -> Unit = {}
) {
    if (args != null) {
        navigate(screen.withArgs(args), builder)
    } else {
        navigate(screen.route, builder)
    }

}








