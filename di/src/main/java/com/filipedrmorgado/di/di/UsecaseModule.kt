package com.filipedrmorgado.di.di

import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import com.filipedrmorgado.domain.usecase.CreateWalletUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCasesModule = module {
    single(named("createWalletUseCase")) { provideCreateWalletUseCase(get()) }

}

private fun provideCreateWalletUseCase(userWalletDataRepository: UserWalletDataRepository) : CreateWalletUseCase {
    return CreateWalletUseCase(userWalletDataRepository)
}