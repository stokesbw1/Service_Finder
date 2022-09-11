package com.example.serviceprovider

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var settings: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstRun = settings.getBoolean(Constants.FIRST_RUN_SPREFERENCES, false)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        if (!firstRun)
        {
            graph.setStartDestination(R.id.splashScreenFragment)
        } else {
            graph.setStartDestination(R.id.firstOptionScreenFragment)
        }

        val navController = navHostFragment.navController
        navController.setGraph(graph, intent.extras)
    }
}