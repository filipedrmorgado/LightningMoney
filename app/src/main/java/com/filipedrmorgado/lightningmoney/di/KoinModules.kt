package com.filipedrmorgado.lightningmoney.di

import com.filipedrmorgado.lightningmoney.ui.ftu.FtuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { FtuViewModel() }
}

val useCasesModule = module {

}
