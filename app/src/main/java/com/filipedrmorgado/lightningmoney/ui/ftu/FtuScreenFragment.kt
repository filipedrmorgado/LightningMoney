package com.filipedrmorgado.lightningmoney.ui.ftu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.filipedrmorgado.lightningmoney.databinding.WelcomeScreenFragmentBinding
import org.koin.core.component.KoinComponent

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FtuScreenFragment : Fragment(), KoinComponent {

    private lateinit var binding:  WelcomeScreenFragmentBinding
    private val ftuViewModel: FtuViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WelcomeScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}