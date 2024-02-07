package com.example.fakestore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fakestore.ui.compose.route.DetailProductRoute
import com.example.fakestore.ui.compose.route.LoginRoute
import com.example.fakestore.ui.compose.route.MainScreenRoute

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.Login.route) {
            LoginRoute(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreenRoute(navController = navController)
        }
        composable(
            route = Screen.DetailProduct.route,
            arguments = listOf(navArgument(PRODUCT_ID){type = NavType.StringType})
        ) { navBackStackEntry ->
            val productId = navBackStackEntry.arguments?.getString(PRODUCT_ID)
            productId.let {
                if (it != null) {
                    DetailProductRoute(it)
                }
            }


        }
    }

}


