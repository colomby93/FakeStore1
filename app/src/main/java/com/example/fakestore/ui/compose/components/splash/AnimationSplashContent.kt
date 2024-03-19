package com.example.fakestore.ui.compose.components.splash

import android.util.Log
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkStatus
import com.example.fakestore.ui.viewmodel.SplashEvent
import kotlinx.coroutines.delay

@Composable
fun AnimationSplashContent(
    token: Boolean,
    scaleAnimation: Animatable<Float, AnimationVector1D>,
    onEvent: (SplashEvent) -> Unit,
    durationMillisAnimation: Int,
    delayScreen: Long,
    networkStatus: State<NetworkStatus>
) {

    LaunchedEffect(key1 = true) {
        Log.e("token animation", "$token")
        scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = durationMillisAnimation,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )
        delay(timeMillis = delayScreen)
        if (networkStatus.value == NetworkStatus.Connected) {
            if (token) {
                onEvent(SplashEvent.NavigationToMainScreen)
            } else {
                onEvent(SplashEvent.NavigationToLoginScreen)
            }
        } else {
            onEvent(SplashEvent.NavigationToFailConnectionScreen)
        }


    }
}
