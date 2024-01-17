package com.example.fakestore.ui.data.preference.di

import android.content.Context
import com.example.fakestore.ui.data.preference.CommonPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {
    @Singleton
    @Provides
    fun providePreference(@ApplicationContext context: Context): CommonPreference {
        return CommonPreference(context)
    }
}