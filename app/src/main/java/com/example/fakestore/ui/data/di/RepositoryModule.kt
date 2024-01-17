package com.example.fakestore.ui.data.di

import com.example.fakestore.ui.data.CommonRepository
import com.example.fakestore.ui.data.Repository
import com.example.fakestore.ui.data.network.CommonNetworkDatasource
import com.example.fakestore.ui.data.network.NetworkDatasource
import com.example.fakestore.ui.data.preference.CommonPreference
import com.example.fakestore.ui.data.preference.Preference
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
    abstract fun bindPreference(preference: CommonPreference): Preference
}