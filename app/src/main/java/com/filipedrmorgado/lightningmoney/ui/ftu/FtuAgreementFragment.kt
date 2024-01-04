package com.filipedrmorgado.lightningmoney.ui.ftu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.FtuAgreementFragmentBinding
import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
import org.koin.core.component.KoinComponent

/**
 * This fragment will deal with First Time Use of the application by the user.
 */
class FtuAgreementFragment : Fragment(), KoinComponent {

    private lateinit var binding:  FtuAgreementFragmentBinding
    private lateinit var navController: NavController
    private val ftuViewModel: FtuViewModel by activityViewModels()

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
     * Sets behaviour for the back behaviour in toolbar and Next screen logic.
     */
    private fun setupObservers() {
        // Set OnClickListener for the back behaviour
        binding.toolbarLayout.btnBack.setOnClickListener {
            navController.popBackStack()
        }

        binding.toolbarLayout.toolbarTitle .setOnClickListener {
            navController.popBackStack()
        }

        binding.btnAgreementNext.setOnClickListener {
            val isFirstConsentChecked = binding.swtFirsConsent.isChecked
            val isSecondConsentChecked = binding.swtSecondConsent.isChecked

            if(isFirstConsentChecked && isSecondConsentChecked) {
                navController.navigate(R.id.action_FtuAgreementFragment_to_FtuWalletName)
            } else {

            }
        }

    }
}