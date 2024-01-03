package com.filipedrmorgado.data.di

import com.filipedrmorgado.data.repositories.UserWalletDataRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single<UserWalletDataRepositoryImpl> { UserWalletDataRepositoryImpl(get(),get()) }
}