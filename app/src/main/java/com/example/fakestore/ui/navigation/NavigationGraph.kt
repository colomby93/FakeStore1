package com.example.fakestore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fakestore.ui.compose.route.LoginRoute
import com.example.fakestore.ui.viewmodel.ViewModelLogin

@Composable
fun NavigationGraph(viewModelLogin: ViewModelLogin){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route){
        composable(Screen.Login.route){
            LoginRoute(viewModelLogin)
        }
    }

}