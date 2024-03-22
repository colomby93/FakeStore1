package com.example.fakestore.ui.compose.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.fakestore.R
import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkStatus
import com.example.fakestore.ui.compose.components.splash.AnimationSplashContent
import com.example.fakestore.ui.compose.components.splash.DesignSplashScreen
import com.example.fakestore.ui.viewmodel.SplashEvent

@Composable
fun SplashScreen(
    token: Boolean,
    networkStatus: State<NetworkStatus>,
    onEvent: (SplashEvent) -> Unit
) {

    val scaleAnimation: Animatable<Float, AnimationVector1D> =
        remember { Animatable(initialValue = 0f) }

    AnimationSplashContent(
        token = token,
        scaleAnimation = scaleAnimation,
        onEvent = onEvent,
        durationMillisAnimation = 1500,
        delayScreen = 3000L,
        networkStatus = networkStatus
    )

    DesignSplashScreen(
        imagePainter = painterResource(
            id =
            R.drawable.pngegg
        ),
        scaleAnimation = scaleAnimation
    )
}

@Preview
@Composable
fun SplashScreenPreview() {
    //SplashScreen()
}