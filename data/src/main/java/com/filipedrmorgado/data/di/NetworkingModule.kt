package com.filipedrmorgado.data.di

import com.filipedrmorgado.data.remote.NetworkConnectionInterceptor
import com.filipedrmorgado.data.remote.api.LightningAPI
import org.koin.dsl.module

/**
 * Koin module for providing networking dependencies.
 */
val networkingModule = module {
    single {
        provideLightningApi(get())
    }
    single {
        NetworkConnectionInterceptor(get())
    }
}

private fun provideLightningApi(networkConnectionInterceptor: NetworkConnectionInterceptor): LightningAPI {
    return LightningAPI(networkConnectionInterceptor)
}
