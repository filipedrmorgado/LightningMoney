package com.filipedrmorgado.lightningmoney.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.ActivityMainBinding
import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private val ftuViewModel: FtuViewModel by viewModel()

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
        navController = (supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment).navController

        lifecycleScope.launch {
           val hasWalletBeenCreated = ftuViewModel.hasWalletBeenCreated()
            if (hasWalletBeenCreated) {
                // Navigate to another screen (replace this with your actual logic)
                navController.navigate(R.id.HomeScreen)
            } else {
                // If the user doesn't have a wallet, navigate to FtuScreenFragment using Navigation component
                navController.navigate(R.id.FtuScreenFragment)
            }
        }
    }
}