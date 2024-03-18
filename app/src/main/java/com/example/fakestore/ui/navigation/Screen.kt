package com.example.fakestore.ui.navigation

var PRODUCT_ID = "product_id"
var USER_ID = "user_id"

sealed class Screen(val route: String) {
    data object Splash : Screen(route = "splash")
    data object Login : Screen(route = "login")
    data object MainScreen : Screen(route = "MainScreen")
    data object DetailProduct : Screen(route = "DetailProduct/{$PRODUCT_ID}")
    data object SearchProduct : Screen(route = "SearchProduct")
    data object UserProfile : Screen(route = "userProfile")
    data object EditEmail : Screen(route = "ChangeEmail/{$USER_ID}")
    data object ChangePassword : Screen(route = "ChangePassword/{$USER_ID}")


    fun withArgs(vararg args: Pair<String, String>): String {
        // replace all keys with values
        var newRoute = route
        args.forEach { (key, value) ->
            newRoute = newRoute.replace("{$key}", value)
        }
        return newRoute
    }

}