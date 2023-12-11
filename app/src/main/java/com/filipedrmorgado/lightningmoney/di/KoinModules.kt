package com.filipedrmorgado.lightningmoney.di

import android.app.Activity
import com.filipedrmorgado.lightningmoney.navigation.NavigationManager
import com.filipedrmorgado.lightningmoney.ui.ftu.FtuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { FtuViewModel() }
}

val useCasesModule = module {

}

val diModule = module {
    single { (activity: Activity) -> NavigationManager(activity) }
}
