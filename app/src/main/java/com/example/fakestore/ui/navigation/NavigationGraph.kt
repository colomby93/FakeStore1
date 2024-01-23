package com.example.fakestore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fakestore.ui.compose.route.MainScreenRoute
import com.example.fakestore.ui.compose.route.LoginRoute
import com.example.fakestore.ui.viewmodel.LoginViewModel

@Composable
fun NavigationGraph(loginViewModel: LoginViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.FirstRoute.route) {
        composable(Screen.Login.route) {
            LoginRoute(loginViewModel, navController = navController)
        }
        composable(Screen.FirstRoute.route) {
            MainScreenRoute()
        }
    }

}