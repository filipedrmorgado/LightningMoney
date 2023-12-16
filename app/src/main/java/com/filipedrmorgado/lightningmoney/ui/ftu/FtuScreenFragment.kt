package com.filipedrmorgado.lightningmoney.ui.ftu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.filipedrmorgado.lightningmoney.R
import com.filipedrmorgado.lightningmoney.databinding.WelcomeScreenFragmentBinding
import com.filipedrmorgado.lightningmoney.navigation.OpenBehaviour
import com.filipedrmorgado.lightningmoney.navigation.OpenScreen
import com.filipedrmorgado.lightningmoney.navigation.ScreenNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FtuScreenFragment : Fragment(), KoinComponent {

    private lateinit var binding:  WelcomeScreenFragmentBinding
    private val ftuViewModel: FtuViewModel by activityViewModels()
    private val navigatorManager: ScreenNavigator by inject()

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


        lifecycleScope.launch {

        delay(5000)
        navigatorManager.openScreen(
            OpenScreen(
                TestFragment::class.java,
                containerViewId = R.id.fcv_main,
                openBehaviour = OpenBehaviour.REPLACE_CURRENT
            )
        )
        }


    }
}