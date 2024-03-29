package com.filipedrmorgado.lightningmoney.ui.ftu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.FtuAgreementFragmentBinding
import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

/**
 * This fragment will deal with First Time Use Agreement screen of the application by the user.
 */
class FtuAgreementFragment : Fragment(), KoinComponent {

    private lateinit var binding:  FtuAgreementFragmentBinding
    private lateinit var navController: NavController
    private val ftuViewModel: FtuViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FtuAgreementFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initializing the NavController
        navController = Navigation.findNavController(requireActivity(), R.id.fcv_main)
        setupObservers()
    }


    /**
     * Sets behaviour for the toolbar behaviour in toolbar and next screen logic.
     */
    private fun setupObservers() {
        // Set OnClickListener for the back behaviour
        binding.toolbarLayout.btnBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.toolbarLayout.toolbarTitle .setOnClickListener {
            navController.popBackStack()
        }

        // Advances to next screen when both agreements are checked. Displays message when a check is missing.
        binding.btnAgreementNext.setOnClickListener {
            val isFirstConsentChecked = binding.swtFirsConsent.isChecked
            val isSecondConsentChecked = binding.swtSecondConsent.isChecked

            if(isFirstConsentChecked && isSecondConsentChecked) {
                navController.navigate(R.id.action_FtuAgreementFragment_to_FtuWalletName)
            } else {
                //todo custom toast to say you have to agree
                Toast.makeText(
                    requireContext(),
                    "You have to agree all the conditions to continue.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}