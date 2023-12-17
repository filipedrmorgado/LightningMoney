package com.filipedrmorgado.lightningmoney.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.filipedrmorgado.lightningmoney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupInitialScreen()
    }


    /**
     * Setting up the FTU/Home screen based on if the user already has a wallet
     */
    private fun setupInitialScreen() {
        val hasWallet = false //todo finish logic

        if (hasWallet) {
            // Navigate to another screen (replace this with your actual logic)
        } else {
            // If the user doesn't have a wallet, navigate to FtuScreenFragment
            //todo logic related to navigation graph
        }
    }


}