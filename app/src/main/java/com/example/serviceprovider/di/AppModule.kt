package com.example.serviceprovider.di

import android.app.Application
import com.example.serviceprovider.Constants
import com.example.serviceprovider.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named(Constants.ARRAY_LIST_STRING1)
    fun provideSplashFirstLine(context: Application): ArrayList<String> {
        return context.resources.getStringArray(R.array.SPLASH_TITLE_FIRST_LINE_LIST)
            .toList() as ArrayList<String>
    }

    @Provides
    @Singleton
    @Named(Constants.ARRAY_LIST_STRING2)
    fun provideSplashSecondLine(context: Application): ArrayList<String> {
        return context.resources.getStringArray(R.array.SPLASH_TITLE_SECOND_LINE_LIST)
            .toList() as ArrayList<String>
    }

    @Provides
    @Singleton
    @Named(Constants.STRING1)
    fun provideSplashDecText(context: Application): String {
        return context.resources.getString(R.string.SPLASH_DESC)
    }
}