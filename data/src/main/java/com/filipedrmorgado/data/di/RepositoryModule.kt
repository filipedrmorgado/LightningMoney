package com.filipedrmorgado.data.di

import com.filipedrmorgado.data.repositories.UserWalletDataRepositoryImpl
import com.filipedrmorgado.domain.repository.UserWalletDataRepository
import org.koin.dsl.module


val repositoriesModule = module {
    single<UserWalletDataRepository> { UserWalletDataRepositoryImpl(get(), get()) }
}