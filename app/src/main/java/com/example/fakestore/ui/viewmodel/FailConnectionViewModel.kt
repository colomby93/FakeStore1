package com.example.fakestore.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.fakestore.ui.navigation.Screen
import com.example.fakestore.ui.navigation.navigate

class FailConnectionViewModel() :
    ViewModel() {


    fun onEvent(failConnectionEvent: FailConnectionEvent, navController: NavController) {
        when (failConnectionEvent) {
            FailConnectionEvent.OnClickButtonTryAgain -> navigationToSplash(navController = navController)
        }
    }

    private fun navigationToSplash(navController: NavController) {
        navController.navigate(Screen.Splash)
    }


}

sealed class FailConnectionEvent {
    data object OnClickButtonTryAgain : FailConnectionEvent()
}