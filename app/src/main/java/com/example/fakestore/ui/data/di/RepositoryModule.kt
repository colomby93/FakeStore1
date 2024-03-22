package com.example.fakestore.ui.data.di

import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkConnectivityService
import com.example.fakestore.ui.compose.components.failConnectionInternet.NetworkConnectivityServiceImpl
import com.example.fakestore.ui.data.CommonRepository
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.data.network.CommonNetworkDatasource
import com.example.fakestore.ui.data.network.NetworkDatasource
import com.example.fakestore.ui.data.preference.CommonPreferences
import com.example.fakestore.ui.data.preference.Preferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repository: CommonRepository): Repository

    @Binds
    abstract fun bindNetworkRepository(remoteDatasource: CommonNetworkDatasource): NetworkDatasource

    @Binds
    abstract fun bindPreference(preference: CommonPreferences): Preferences

    @Binds
    abstract fun bindNetworkConnectivity(networkConnectivityServiceImpl: NetworkConnectivityServiceImpl): NetworkConnectivityService

}