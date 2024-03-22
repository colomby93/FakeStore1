package com.example.fakestore.ui.compose.components.failConnectionInternet.di

import android.content.Context
import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkConnectivityServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkConnectivityModule {
    @Singleton
    @Provides
    fun provideNetworkConnectivityServiceImpl(@ApplicationContext context: Context): NetworkConnectivityServiceImpl {
        return NetworkConnectivityServiceImpl(context)
    }
}