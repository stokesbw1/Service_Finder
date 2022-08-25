package com.example.serviceprovider.di

import android.app.Application
import android.view.LayoutInflater
import android.view.Window
import androidx.core.content.getSystemService
import com.example.serviceprovider.databinding.ActivityMainBinding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    fun provideViewBinding(layoutInflater: LayoutInflater?) : ActivityMainBinding{
        return ActivityMainBinding.inflate(layoutInflater!!)
    }

    @Provides
    fun provideLayoutInflater(context: Application) : LayoutInflater? {
        return context.getSystemService()
    }
}