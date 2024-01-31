package com.filipedrmorgado.lightningmoney.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.filipedrmorgado.domain.model.UserWallet
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.HomeScreenFragmentBinding
import com.filipedrmorgado.lightningmoney.ui.homescreen.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

/**
 * This fragment will deal with the home screen of the application.
 */
class HomeScreenFragment : Fragment(), KoinComponent {

    private lateinit var binding: HomeScreenFragmentBinding
    private lateinit var navController: NavController
    private val homeScreenViewModel: HomeScreenViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initializing the NavController
        navController = Navigation.findNavController(requireActivity(), R.id.fcv_main)
        setupObservers()
    }


    /**
     * Sets behaviour for the back behaviour in toolbar and Next screen logic.
     */
    private fun setupObservers() {
        // Set OnClickListener for the back behaviour
        binding.toolbarLayout.btnProfile.setOnClickListener {
            //todo implement profile section
        }

        binding.toolbarLayout.btnSettings.setOnClickListener {
            //todo implement settings section
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeScreenViewModel.userWalletData.collect {
                    updateHomeScreenWalletData(it)
                }
            }
        }
    }

    private fun updateHomeScreenWalletData(userWallet: UserWallet?) {
        val balanceText = getString(R.string.wallet_balance_format, userWallet?.balanceMsat.toString())
        binding.tvWalletBalance.text = balanceText
        //todo yet to implement the api to make updated conversions to other FIAT.
        //note to self: keep data of fiat currencies cached if possible, to avoid api requests every update. Unless the request is fast.
        binding.tvWalletSecondaryBalance.text = "€ 0"
    }
}