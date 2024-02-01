package com.example.fakestore.ui.navigation

sealed class Screen(val route: String) {
    data object Login : Screen(route = "login")
    data object MainScreen : Screen(route = "MainScreen")
    data object DetailProduct : Screen(route = "DetailProduct")
}