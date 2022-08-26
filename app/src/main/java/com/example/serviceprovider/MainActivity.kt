package com.example.serviceprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.serviceprovider.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var  viewPagerAdapter: RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpViewPager()
    }

    private fun setUpViewPager(){
        binding.viewPager2.adapter = viewPagerAdapter
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.indicator.setViewPager(binding.viewPager2)
    }
}