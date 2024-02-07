package com.example.fakestore.ui.navigation

var PRODUCT_ID = "product_id"

sealed class Screen(val route: String) {
    data object Login : Screen(route = "login")
    data object MainScreen : Screen(route = "MainScreen")
    data object DetailProduct : Screen(route = "DetailProduct/$PRODUCT_ID")

    fun withArgs(vararg args: Pair<String, String>): String {
        // replace all keys with values
        var newRoute = route
        args.forEach { (key, value) ->
            newRoute = newRoute.replace("{$key}", value)
        }
        return newRoute
    }

}