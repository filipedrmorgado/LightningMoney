package com.filipedrmorgado.di.di

import com.filipedrmorgado.domain.repository.FtuRepository
import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import com.filipedrmorgado.domain.usecase.CacheAdminKeyUseCase
import com.filipedrmorgado.domain.usecase.CreateWalletUseCase
import com.filipedrmorgado.domain.usecase.HasWalletBeenCreatedUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCasesModule = module {
    single(named("createWalletUseCase")) { provideCreateWalletUseCase(get()) }
    single(named("cacheAdminKeyUseCase")) { provideCacheAdminKeyUseCase(get()) }
    single(named("hasWalletBeenCreatedUseCase")) { provideHasWalletBeenCreatedUseCase(get()) }
}

private fun provideCreateWalletUseCase(ftuRepository: FtuRepository) : CreateWalletUseCase {
    return CreateWalletUseCase(ftuRepository)
}

private fun provideCacheAdminKeyUseCase(userWalletDataRepository: UserWalletDataRepository) : CacheAdminKeyUseCase {
    return CacheAdminKeyUseCase(userWalletDataRepository)
}

private fun provideHasWalletBeenCreatedUseCase(userWalletDataRepository: UserWalletDataRepository) : HasWalletBeenCreatedUseCase {
    return HasWalletBeenCreatedUseCase(userWalletDataRepository)
}