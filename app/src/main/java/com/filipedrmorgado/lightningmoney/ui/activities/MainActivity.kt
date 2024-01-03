package com.filipedrmorgado.lightningmoney.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup nav controller
        navController = (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).navController

        setupInitialScreen()
    }



    /**
     * Setting up the FTU/Home screen based on if the user already has a wallet
     */
    private fun setupInitialScreen() {
        val hasWallet = false //todo finish logic

        if (hasWallet ) {
            // Navigate to another screen (replace this with your actual logic)
        } else {
            // If the user doesn't have a wallet, navigate to FtuScreenFragment using Navigation component
            navController = (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).navController
            navController.navigate(R.id.FtuScreenFragment)
        }
    }
}