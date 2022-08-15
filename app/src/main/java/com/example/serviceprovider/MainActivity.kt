package com.example.serviceprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import me.relex.circleindicator.CircleIndicator3
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

fun setUpViewPager(){
      val titlesList = ArrayList<String>(listOf(*resources.getStringArray(R.array.FIRST_TITLE_LIST)))
      val descList = ArrayList<String>(listOf(*resources.getStringArray(R.array.SPLASH_DESC)))

    view_pager2.adapter=ViewPagerAdapter(titlesList, descList, listOf(R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round))
    view_pager2.orientation =ViewPager2.ORIENTATION_HORIZONTAL

    var  indicator:CircleIndicator3 = findViewById<CircleIndicator3>(R.id.indicator)
    indicator.setViewPager(view_pager2)
}
}