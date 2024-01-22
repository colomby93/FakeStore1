package com.example.fakestore.ui.view.di

import android.app.Activity
import android.content.Context
import com.example.fakestore.ui.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ActivityComponent::class)
@Module
object ActivityModule {
    @Provides
    fun bindMainActivity(activity: Activity): MainActivity = activity as MainActivity
}