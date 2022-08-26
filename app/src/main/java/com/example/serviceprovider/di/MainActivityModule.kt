package com.example.serviceprovider.di

import android.app.Application
import android.view.LayoutInflater
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.example.serviceprovider.Constants
import com.example.serviceprovider.R
import com.example.serviceprovider.ViewPagerAdapter
import com.example.serviceprovider.databinding.ActivityMainBinding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object MainActivityModule {

    @Provides
    fun provideViewBinding(layoutInflater: LayoutInflater?) : ActivityMainBinding{
        return ActivityMainBinding.inflate(layoutInflater!!)
    }

    @Provides
    fun provideLayoutInflater(context: Application) : LayoutInflater? {
        return context.getSystemService()
    }

    @Provides
    fun provideViewpageAdapter(
        @Named(Constants.ARRAY_LIST_STRING1) titlesFirstLineList: ArrayList<String>,
        @Named(Constants.ARRAY_LIST_STRING2) titlesSecondLineList: ArrayList<String>,
        @Named(Constants.STRING1) descText: String,
    ) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>{
        return ViewPagerAdapter(
            titlesFirstLineList,
            titlesSecondLineList,
            descText,
        )
    }
}