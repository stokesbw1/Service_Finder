package com.example.serviceprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.serviceprovider.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import me.relex.circleindicator.CircleIndicator3
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var binding: ActivityMainBinding // <----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpViewPager()
    }

    private fun setUpViewPager(){
        val titlesFirstLineList = ArrayList<String>(listOf(*resources.getStringArray(R.array.SPLASH_TITLE_FIRST_LINE_LIST)))
        val titlesSecondLineList = ArrayList<String>(listOf(*resources.getStringArray(R.array.SPLASH_TITLE_SECOND_LINE_LIST)))
        val descText = getString(R.string.SPLASH_DESC)

        binding.viewPager2.adapter=ViewPagerAdapter(
            titlesFirstLineList,
            titlesSecondLineList,
            descText,
           )
        binding.viewPager2.orientation =ViewPager2.ORIENTATION_HORIZONTAL

        var  indicator:CircleIndicator3 = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(binding.viewPager2)
    }
}