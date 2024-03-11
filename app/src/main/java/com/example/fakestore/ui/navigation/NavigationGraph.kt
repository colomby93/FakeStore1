package com.example.fakestore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fakestore.ui.compose.route.DetailProductRoute
import com.example.fakestore.ui.compose.route.EditEmailRoute
import com.example.fakestore.ui.compose.route.LoginRoute
import com.example.fakestore.ui.compose.route.MainScreenRoute
import com.example.fakestore.ui.compose.route.SearchProductRoute
import com.example.fakestore.ui.compose.route.UserProfileRoute

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) {
            LoginRoute(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreenRoute(navController = navController)
        }
        composable(
            route = Screen.DetailProduct.route,
            arguments = listOf(navArgument(PRODUCT_ID) { type = NavType.StringType })
        ) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getString(PRODUCT_ID)
            if (productId != null) {
                DetailProductRoute(productId, navController = navController)
            }
        }
        composable(route = Screen.SearchProduct.route) {
            SearchProductRoute(navController = navController)
        }
        composable(
            route = Screen.UserProfile.route
        ) {
            UserProfileRoute(navController = navController)
        }
        composable(
            route = Screen.EditEmail.route,
            arguments = listOf(navArgument(USER_ID) { type = NavType.StringType })
        ) {
            val userId = it.arguments?.getString(USER_ID)
            if (userId != null) {
                EditEmailRoute(userId, navController = navController)
            }
        }
    }

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


