package com.filipedrmorgado.lightningmoney.di

import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        FtuViewModel(
            createWalletUseCase = get(named("createWalletUseCase"))
        )
    }
}
