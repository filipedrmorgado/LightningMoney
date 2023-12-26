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
import com.filipedrmorgado.lightningmoney.databinding.FtuWalletNameBinding
import org.koin.core.component.KoinComponent

/**
 * This fragment will deal with First Time Use of the application by the user.
 */
class FtuWalletNameFragment : Fragment(), KoinComponent {

    private lateinit var binding:  FtuWalletNameBinding
    private lateinit var navController: NavController
    private val ftuViewModel: FtuViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FtuWalletNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initializing the NavController
        navController = Navigation.findNavController(requireActivity(), R.id.fcv_main)
    }
}