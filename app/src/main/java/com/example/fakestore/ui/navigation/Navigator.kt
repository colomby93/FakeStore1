/*package com.example.fakestore.ui.navigation

import androidx.navigation.NavController
import javax.inject.Inject


interface Navigator {

    fun navigationToHome()

    fun navigationToFirstRoute()


    fun popBackStack()
}


class AndroidNavigator @Inject constructor() : Navigator {

    private var navController: NavController? = null

    fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun navigationToHome() {
        this.navController?.navigate(Screen.Login.route)
    }

    override fun navigationToFirstRoute() {
        navController?.navigate(Screen.FirstRoute.route)
    }

    override fun popBackStack() {
        navController?.popBackStack()
    }

}*/