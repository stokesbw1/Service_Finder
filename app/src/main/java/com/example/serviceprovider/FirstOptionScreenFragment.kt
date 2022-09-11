package com.example.serviceprovider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.serviceprovider.databinding.FragmentFirstOptionScreenBinding
import com.example.serviceprovider.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@WithFragmentBindings
@AndroidEntryPoint
class FirstOptionScreenFragment : Fragment() {
    private lateinit var binding: FragmentFirstOptionScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstOptionScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAsGuest.setOnClickListener{
            findNavController().navigate(R.id.action_firstOptionScreenFragment_to_secondOptionsScreenFragment)
        }

        binding.btnJoinNow.setOnClickListener{
            findNavController().navigate(R.id.action_firstOptionScreenFragment_to_registerFragment)
        }
    }
}