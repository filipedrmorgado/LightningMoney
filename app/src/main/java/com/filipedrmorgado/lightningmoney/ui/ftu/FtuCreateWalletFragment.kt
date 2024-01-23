package com.filipedrmorgado.lightningmoney.ui.ftu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.FtuCreateWalletFragmentBinding
import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
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
    }

    private fun setupObservers() {
        // Set OnClickListener for the back behaviour
        binding.toolbarLayout.btnBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.toolbarLayout.toolbarTitle .setOnClickListener {
            navController.popBackStack()
        }

        binding.btnCreateWallet.setOnClickListener {
            ftuViewModel.createWallet(binding.tvNameWallet.text.toString())
        }
    }
}