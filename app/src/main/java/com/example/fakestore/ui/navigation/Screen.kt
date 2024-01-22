package com.example.fakestore.ui.navigation

sealed class Screen (val route: String){
    data object Login : Screen("login")
    data object FirstRoute: Screen("firstRoute")
}