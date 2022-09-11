package com.example.serviceprovider

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.serviceprovider.databinding.FragmentSplashScreenBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import javax.inject.Inject
import javax.inject.Named

@WithFragmentBindings
@AndroidEntryPoint
class SplashScreenFragment : Fragment() {
    private lateinit var binding: FragmentSplashScreenBinding

    @Inject  lateinit var viewPagerAdapter: ViewPagerAdapter
    @Inject lateinit var settings: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSplashNext.setOnClickListener{

            if (binding.vpSplashPager.currentItem == 2){
                val editor = settings.edit()
                editor.putBoolean(Constants.FIRST_RUN_SPREFERENCES, true)
                editor.apply()

                findNavController().navigate(R.id.action_splashScreenFragment_to_firstOptionScreenFragment)
            }

            binding.vpSplashPager.currentItem = binding.vpSplashPager.currentItem + 1
        }

        binding.btnSplashSkip.setOnClickListener{
            binding.vpSplashPager.currentItem = binding.vpSplashPager.currentItem - 1;
        }
        setUpViewPager()
    }

    private fun setUpViewPager(){
        binding.vpSplashPager.adapter = viewPagerAdapter
        binding.vpSplashPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.inSplashDots.setViewPager(binding.vpSplashPager)
    }
}