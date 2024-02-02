package com.filipedrmorgado.lightningmoney.di

import com.filipedrmorgado.lightningmoney.ui.ftu.viewmodel.FtuViewModel
import com.filipedrmorgado.lightningmoney.ui.homescreen.viewmodel.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Koin module for providing view model dependencies.
 */
val viewModelsModule = module {
    viewModel {
        FtuViewModel(
            createWalletUseCase = get(named("createWalletUseCase")),
            hasWalletBeenCreatedUseCase = get(named("hasWalletBeenCreatedUseCase"))
        )
    }
    viewModel {
        HomeScreenViewModel(
            updateUserDataUseCase = get(named("updateUserDataUseCase"))
        )
    }
}
