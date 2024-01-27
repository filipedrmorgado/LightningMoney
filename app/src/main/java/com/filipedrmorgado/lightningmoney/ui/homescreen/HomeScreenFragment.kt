package com.filipedrmorgado.lightningmoney.ui.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.HomeScreenFragmentBinding
import com.filipedrmorgado.lightningmoney.ui.homescreen.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

/**
 * This fragment will deal with the home screen of the application.
 */
class HomeScreenFragment : Fragment(), KoinComponent {

    private lateinit var binding: HomeScreenFragmentBinding
    private lateinit var navController: NavController
    //todo change to HomeScreenViewModel
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
    }
}