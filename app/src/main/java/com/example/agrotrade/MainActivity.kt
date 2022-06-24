package com.example.agrotrade

import android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var receiver:AirplaneModeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = AirplaneModeReceiver()
        IntentFilter(ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver,it)
        }
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        navController = findNavController(R.id.NavHostFragment)

        setupActionBarWithNavController(
            navController, AppBarConfiguration(
                setOf(
                    R.id.homeFragment,
                    R.id.productFragment,
                    R.id.userFragment,
                    R.id.registrationFragment,
                    R.id.aboutUs,
                    R.id.addProductFragment

                )
            )
        )
        bottomNavigationView.setupWithNavController(navController)


    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}