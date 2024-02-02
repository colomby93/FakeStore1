package com.example.fakestore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fakestore.ui.compose.route.DetailProductRoute
import com.example.fakestore.ui.compose.route.LoginRoute
import com.example.fakestore.ui.compose.route.MainScreenRoute

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(route = Screen.Login.route) {
            LoginRoute(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreenRoute()
        }
        composable(route = Screen.DetailProduct.route) {
            DetailProductRoute()
        }
    }

}