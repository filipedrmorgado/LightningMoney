package com.filipedrmorgado.lightningmoney.ui.ftu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.FtuCreateWalletFragmentBinding
import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.WalletCreationState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent


/**
 * This fragment will deal with First Time Use of the application by the user.
 */
class FtuCreateWalletFragment : Fragment(), KoinComponent {

    private lateinit var binding:  FtuCreateWalletFragmentBinding
    private lateinit var navController: NavController
    private val ftuViewModel: FtuViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FtuCreateWalletFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initializing the NavController
        navController = Navigation.findNavController(requireActivity(), R.id.fcv_main)
        setupObservers()
        setupCollectors()
        setupUi()
    }

    private fun setupUi() {
        binding.etInputField.setHint(R.string.tv_wallet_name_hint)
    }

    private fun setupCollectors() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                ftuViewModel.walletCreationState.collect { state ->
                    Log.d("FtuCreateWalletFragment","setupCollectors.: state=$state")
                    handleWalletCreationState(state)
                }
            }
        }
    }

    /**
     * Handles states updates related to creation of the wallet.
     */
    private fun handleWalletCreationState(state: WalletCreationState) {
        when(state) {
            WalletCreationState.NotStarted -> {
                // Do nothing
            }
            WalletCreationState.Loading -> {
                //todo add a loading indicator to the user

            }
            WalletCreationState.Error -> {
                //todo create a custom toast for every toast in the project
                Toast.makeText(
                    requireContext(),
                    "An error occurred trying to create the wallet. Try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            WalletCreationState.Success -> {
                navController.popBackStack(R.id.FtuScreenFragment, false)
                navController.navigate(R.id.HomeScreen)
            }
        }
    }

    private fun setupObservers() {
        // Set OnClickListener for the back behaviour
        binding.toolbarLayout.btnBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.toolbarLayout.toolbarTitle .setOnClickListener {
            navController.popBackStack()
        }

        // Create wallet when clicking the create btn. Display a message when user didn't up any name.
        binding.btnCreateWallet.setOnClickListener {
            //Display when the length of the name is 0
            if(binding.etInputField.text?.isEmpty() == true) {
                Toast.makeText(
                    requireContext(),
                    "Please make sure you insert your wallet name.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                ftuViewModel.createWallet(binding.etInputField.text.toString())
            }
        }

        // Handles text input field hint, to show and hide.
        binding.etInputField.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus || binding.etInputField.text?.isNotEmpty() == true) {
                binding.etInputField.hint = ""
            } else {
                binding.etInputField.setHint(R.string.tv_wallet_name_hint)
            }
        }

    }
}