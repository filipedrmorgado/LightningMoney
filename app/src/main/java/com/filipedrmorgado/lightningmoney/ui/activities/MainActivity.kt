package com.filipedrmorgado.lightningmoney.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.filipedrmorgado.lightningmoney.databinding.ActivityMainBinding
import com.filipedrmorgado.lightningmoney.navigation.NavigationManager
import com.filipedrmorgado.lightningmoney.navigation.OpenBehaviour
import com.filipedrmorgado.lightningmoney.navigation.OpenScreen
import com.filipedrmorgado.lightningmoney.ui.ftu.FtuScreenFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //todo review logic on how to get the fragmentManager
    private val navigationManager: NavigationManager by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupInitialScreen()
    }

    /**
     * Setting up the FTU/Home screen based on if the user already has a wallet
     */
    /**
     * Setting up the FTU/Home screen based on if the user already has a wallet
     */
    private fun setupInitialScreen() {
        val hasWallet = false //todo finish logic

        if (hasWallet) {
            // Navigate to another screen (replace this with your actual logic)
            //navigationManager.navigateTo(OpenScreen(/* provide details for the screen to navigate to */))
        } else {
            // If the user doesn't have a wallet, navigate to FtuScreenFragment
           /* navigationManager.navigateTo(
                OpenScreen(
                    FtuScreenFragment::class.java,
                    binding.fcvMain.id,
                    false,
                    OpenBehaviour.ADD
                )
            )*/
        }
    }


}